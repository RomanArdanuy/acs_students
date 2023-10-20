package baseNoStates;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Space extends Area{
  private String name;
  private String description;
  private Partition parentSpace;
  private List<Door> doors;
  private List<Area> children;

  public Space(String name, String description, Partition parentSpace) {
    this.name = name;
    this.description = description;
    this.parentSpace = parentSpace;
  }

  public List<Door> getDoorsGivingAccess()
  {
    return new ArrayList<>(doors);
  }

  public  List<Space> getSpaces()
  {
    return Arrays.asList(this);
  }


}
