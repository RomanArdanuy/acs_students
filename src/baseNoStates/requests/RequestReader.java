package baseNoStates.requests;

import baseNoStates.DirectoryDoors;
import baseNoStates.DirectoryUsers;
import baseNoStates.Door;
import baseNoStates.User;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class RequestReader implements Request {
  private final String credential; // who
  private final String action;     // what
  private final LocalDateTime now; // when
  private final String doorId;     // where
  private String userName;
  private boolean authorized;
  private final ArrayList<String> reasons; // why not authorized
  private String doorStateName;
  private boolean doorClosed;

  public RequestReader(String credential, String action, LocalDateTime now, String doorId) {
    this.credential = credential;
    this.action = action;
    this.doorId = doorId;
    reasons = new ArrayList<>();
    this.now = now;
  }

  public void setDoorStateName(String name) {
    doorStateName = name;
  }

  public String getAction() {
    return action;
  }

  public boolean isAuthorized() {
    return authorized;
  }

  public void addReason(String reason) {
    reasons.add(reason);
  }


  @Override
  public String toString() {
    if (userName == null) {
      userName = "unknown";
    }
    return "Request{"
            + "credential=" + credential
            + ", userName=" + userName
            + ", action=" + action
            + ", now=" + now
            + ", doorID=" + doorId
            + ", closed=" + doorClosed
            + ", authorized=" + authorized
            + ", reasons=" + reasons
            + "}";
  }

  public JSONObject answerToJson() {
    JSONObject json = new JSONObject();
    json.put("authorized", authorized);
    json.put("action", action);
    json.put("doorId", doorId);
    json.put("closed", doorClosed);
    json.put("state", doorStateName);
    json.put("reasons", new JSONArray(reasons));
    return json;
  }

  // see if the request is authorized and put this into the request, then send it to the door.
  // if authorized, perform the action.
  public void process() {
    User user = DirectoryUsers.findUserByCredential(credential);
    Door door = DirectoryDoors.findDoorById(doorId);
    assert door != null : "door " + doorId + " not found";
    authorize(user, door);
    // this sets the boolean authorize attribute of the request
    door.processRequest(this);
    // even if not authorized we process the request, so that if desired we could log all
    // the requests made to the server as part of processing the request
    doorClosed = door.isClosed();
  }

  // the result is put into t he request object plus, if not authorized, why not,
  // only for testing
  private void authorize(User user, Door door) {

    if (user == null) {
      authorized = false;
      addReason("user doesn't exists");
    }
      //TODO: get the who, where, when and what in order to decide, and if not
      // authorized add the reason(s)

    if (!user.hasPermission(action + "_" + door.getId())) {
      authorized = false;
      addReason("User doesn't have permission for this action on the door.");
      return;
    }

    String currentState = door.getStateName();

    if (action.equals("open") && currentState.equals("opened")) {
      authorized = false;
      addReason("Door is already open.");
      return;
    }
    if (action.equals("close") && currentState.equals("Closed")) {
      authorized = false;
      addReason("Door is already closed.");
      return;
    }

    if (action.equals("lock") && currentState.equals("Locked")) {
      authorized = false;
      addReason("Door is already locked.");
      return;
    }

    if (action.equals("unlock") && currentState.equals("Unlocked")) {
      authorized = false;
      addReason("Door is already unlocked.");
      return;
    }
    // If none of the above conditions are met, the action is authorized.
      authorized = true;
    }
}


