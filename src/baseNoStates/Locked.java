package baseNoStates;

public class Locked extends DoorState{

  public Locked(Door door)
  {
    super(door);
    this.name="locked";
  }
  public void open(){
    System.out.println("Door is closed");
  }

  public void close() {
    System.out.println("Door is already closed");
  }

  public void lock() {
    System.out.println("Door is already locked");
  }

  public void unlock() {
    this.door.setState(new Unlocked(door));
  }

}
