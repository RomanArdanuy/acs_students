package baseNoStates;
import java.util.ArrayList;
import java.util.List;

public abstract class Area {

  private String id;
  private List<Area> children;

  public Area(String id) {
    this.id = id;
    this.children = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public Area()
  {
    this.id="";

  }
  public abstract List<Door> getDoorsGivingAccess();
  public abstract List<Space> getSpaces();

  // Other methods and functionalities can be added based on further requirements
}

