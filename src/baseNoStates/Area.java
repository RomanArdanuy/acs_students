package baseNoStates;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
Area is an abstract class we use as component with the design pattern composite
that will have two methods defined as abstract and implemented in the leaf and composite
classes, in this case: space and partition.
*/
public abstract class Area {

  private static Area instance; // Singleton instance for Area
  protected String id;
  protected String description;
  protected Partition parent;
  protected List<Area> children;

  protected List<Door> doorsGivingAccess;

  public Area(String id, String description, Partition parent) {
    this.id = id;
    this.description = description;
    this.parent = parent;
    this.children = new ArrayList<>();
  }
  // Singleton getInstance method for Area
  public static Area getInstance(String id, String description, Partition parent) {
    if (instance == null) {
      if (parent == null) {
        instance = new Partition(id, description, null);
      } else {
        instance = new Space(id, description, parent);
      }
    }
    return instance;
  }
  public String getId() {
    return id;
  }

  public abstract List<Door> getDoorsGivingAccess();
  public abstract List<Space> getSpaces();

  // ... other methods and attributes specific to Area ...
}