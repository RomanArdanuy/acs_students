package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Partition extends Area {

  private static final Logger logger = LoggerFactory.getLogger(Partition.class);

  public Partition(String id, String description, Partition parent) {
    super(id, description, parent);
    if (parent != null) {
      parent.children.add(this);  // Add this partition to the parent's children list
      logger.debug("Partition {} added to parent {}", id, parent.getId());
    }
  }

  @Override
  public List<Door> getDoorsGivingAccess() {
    List<Door> doors = new ArrayList<>();
    for (Area child : children) {
      doors.addAll(child.getDoorsGivingAccess());
    }
    logger.info("Retrieved doors giving access for partition {}", getId());
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
    logger.info("Retrieved spaces for partition {}", getId());
    return spaces;
  }

  public void addDoor(Door door) {
    if (!doorsGivingAccess.contains(door)) {
      doorsGivingAccess.add(door);
      logger.info("Door {} added to partition {}", door.getId(), getId());
    } else {
      logger.warn("Attempted to add a duplicate door {} to partition {}", door.getId(), getId());
    }
  }

  public void removeDoor(Door door) {
    doorsGivingAccess.remove(door);
    logger.info("Door {} removed from partition {}", door.getId(), getId());
  }
}
