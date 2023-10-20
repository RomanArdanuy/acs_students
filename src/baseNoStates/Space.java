package baseNoStates;
import java.util.ArrayList;
import java.util.List;

public class Space extends Area{
  private String name;
  private String description;
  private Partition parentSpace;

  public Space(String name, String description, Partition parentSpace) {
    this.name = name;
    this.description = description;
    this.parentSpace = parentSpace;
  }

  public List<Door> getDoorsGivingAccess()
  {

  }

  public  List<Space> getSpaces()
  {

  }
}
