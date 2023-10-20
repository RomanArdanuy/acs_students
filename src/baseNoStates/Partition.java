package baseNoStates;
import java.util.ArrayList;
import java.util.List;

public class Partition extends Area{
  private String name;
  private String description;
  private Object data;
  private List<Area> children;
  private List<Door> doors;
  public Partition(String name, String description, Object data) {
    this.name = name;
    this.description = description;
    this.data = data;
  }

  public List<Door> getDoorsGivingAccess()
  {
    List<Door> doors=new ArrayList<>();
    for(Area child: children)
    {
      doors.addAll(child.getDoorsGivingAccess());
    }
    return doors;
  }

  public  List<Space> getSpaces() {
    List<Space> spaces = new ArrayList<>();
    for(Area child: children)
    {
      if(child instanceof Space){
        spaces.add((Space) child);
      }else if(child instanceof Partition)
        spaces.addAll(((Partition)child).getSpaces());
    }
    return spaces;
  }




}
