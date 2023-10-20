package baseNoStates;
import java.util.Timer;
import java.util.TimerTask;

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

  @Override
  public void unlockShortly() {
    System.out.println("Unlocking the door shortly...");
    this.door.setState(new Unlocked(door));
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        System.out.println("Re-locking the door...");
        door.setState(new Locked(door));
      }
    }, 5000); // 5 seconds delay
  }


}
