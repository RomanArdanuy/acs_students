package baseNoStates;

public class Space {
  private String name;
  private String description;
  private Partition parentSpace;

  public Space(String name, String description, Partition parentSpace) {
    this.name = name;
    this.description = description;
    this.parentSpace = parentSpace;
  }


}
