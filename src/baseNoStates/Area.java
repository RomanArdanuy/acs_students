package baseNoStates;

import java.util.ArrayList;
import java.util.List;

public abstract class Area {
  protected String id;
  protected String description;
  protected Partition parent;
  protected List<Area> children;

  public Area(String id, String description, Partition parent) {
    this.id = id;
    this.description = description;
    this.parent = parent;
    this.children = new ArrayList<>();
  }
  public String getId() {
    return id;
  }

  public abstract List<Door> getDoorsGivingAccess();
  public abstract List<Space> getSpaces();

  // ... other methods and attributes specific to Area ...
}
