package baseNoStates;

import java.util.ArrayList;
import java.util.List;

public class Partition extends Area {

  public Partition(String id, String description, Partition parent) {
    super(id, description, parent);
    if (parent != null) {
      parent.children.add(this);  // Add this partition to the parent's children list
    }
  }

  @Override
  public List<Door> getDoorsGivingAccess() {
    List<Door> doors = new ArrayList<>();
    for (Area child : children) {
      doors.addAll(child.getDoorsGivingAccess());
    }
    return doors;
  }

  @Override
  public List<Space> getSpaces() {
    List<Space> spaces = new ArrayList<>();
    for (Area child : children) {
      if (child instanceof Space) {
        spaces.add((Space) child);
      } else if (child instanceof Partition) {
        spaces.addAll(child.getSpaces());
      }
    }
    return spaces;
  }

  public void addDoor(Door door) {
    if (!doorsGivingAccess.contains(door)) {
      doorsGivingAccess.add(door);
    }
  }

  public void removeDoor(Door door) {
    doorsGivingAccess.remove(door);
  }
}
