package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
Door is the class that includes all the attributes that our doors need. Doors can be found
inside of our spaces and partitions, and we will save from which space the door comes from
and to which space the door is giving access to.
For all the states a door can be in, we have the doorState class.
 */
public class Door {
  private final String id;
  private boolean closed; // physically
  private static final Logger logger = LoggerFactory.getLogger(Door.class);
  private DoorState state;

  private Partition partition;
  private Space space,space2;




  public Door(String id, Partition partition, Space space)
  {
    this.id=id;
    this.partition=partition;
    this.space=space;
    state= new Unlocked(this);
  }

  public Door(String id, Space space2, Space space)
  {
    this.id=id;
    this.space2=space2;
    this.space=space;
    state= new Unlocked(this);
  }


  public Door(String id) {
    this.id = id;
    closed = true;
    state= new Unlocked(this);
  }



  public void processRequest(RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      logger.info("Not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  private void doAction(String action) {
    switch (action) {
      case Actions.OPEN:
        state.open();
        break;

      case Actions.CLOSE:
        state.close();
        break;

      case Actions.LOCK:
        state.lock();

        break;
      // fall through
      case Actions.UNLOCK:
        // TODO
        state.unlock();
        break;

      // fall through
      case Actions.UNLOCK_SHORTLY:
        // TODO
        state.unlockShortly();
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  public boolean isClosed() {
    return closed;
  }

  public void setClosed(boolean closed)
  {
    this.closed=closed;
  }

  public String getId() {
    return id;
  }

  public String getStateName() {
    return state.name;
  }

  public void setState(DoorState State)
  {
    state=State;
  }
  @Override
  public String toString() {
    return "Door{"
            + ", id='" + id + '\''
            + ", closed=" + closed
            + ", state=" + getStateName()
            + "}";
  }

  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    json.put("state", getStateName());
    json.put("closed", closed);
    return json;
  }
}
