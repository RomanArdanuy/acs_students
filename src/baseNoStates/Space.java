package baseNoStates;

import java.util.ArrayList;
import java.util.List;

public class Space extends Area {

  private List<Door> doorsGivingAccess;  // Assuming each space has a list of doors giving access

  public Space(String id, String description, Partition parent) {
    super(id, description, parent);
    this.doorsGivingAccess = new ArrayList<>();
    if (parent != null) {
      parent.children.add(this);  // Add this space to the parent's children list
    }
  }

  @Override
  public List<Door> getDoorsGivingAccess() {
    return doorsGivingAccess;
  }

  @Override
  public List<Space> getSpaces() {
    List<Space> spaces = new ArrayList<>();
    spaces.add(this);
    return spaces;
  }

  // Assuming you might want to add or remove doors for a space
  public void addDoor(Door door) {
    if (!doorsGivingAccess.contains(door)) {
      doorsGivingAccess.add(door);
    }
  }

  public void removeDoor(Door door) {
    doorsGivingAccess.remove(door);
  }
}
