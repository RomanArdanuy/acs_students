package baseNoStates;

public class Unlocked extends DoorState{

  public Unlocked(Door door)
  {
    super(door);
    this.name="locked";
  }
  public void open(){
    System.out.println("Door is locked");
  }

  public void close() {
    if(door.isClosed())
      System.out.println("Door is already closed");
    else{}
  }

  public void lock() {
    this.door.setState(new Locked(door));
  }

  public void unlock() {
    System.out.println("Already unlocked");
  }

}
