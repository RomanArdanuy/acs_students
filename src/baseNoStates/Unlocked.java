package baseNoStates;

public class Unlocked extends DoorState{

  public Unlocked(Door door)
  {
    super(door);
    this.name="unlocked";
  }
  public void open() {
    if (door.isClosed()) {
      door.setClosed(false);
    } else {
      System.out.println("Door is locked");

    }
  }
  public void close() {
    if(door.isClosed())
      System.out.println("Door is already closed");
    else{
      door.setClosed(true);
    }
  }

  public void lock() {
    if (door.isClosed()) {
      door.setState(new Locked(door));
    } else {
      System.out.println("Door is open");
    }
  }

  public void unlock() {
    System.out.println("Already unlocked");
  }
  @Override
  public void unlockShortly() {
    // Either ignore or set a timer to lock the door after a short duration
  }
}
