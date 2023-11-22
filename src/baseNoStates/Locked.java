package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;

public class Locked extends DoorState {

  private static final Logger logger = LoggerFactory.getLogger(Locked.class);

  public Locked(Door door) {
    super(door);
    this.name = "locked";
    logger.debug("Door state set to locked");
  }

  public void open() {
    logger.warn("Attempt to open a locked door");
  }

  public void close() {
    logger.info("Door is already closed");
  }

  public void lock() {
    logger.info("Door is already locked");
  }

  public void unlock() {
    this.door.setState(new Unlocked(door));
    logger.info("Door unlocked");
  }

  @Override
  public void unlockShortly() {
    logger.info("Unlocking the door shortly...");
    this.door.setState(new Unlocked(door));
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        logger.info("Re-locking the door...");
        door.setState(new Locked(door));
      }
    }, 5000); // 5 seconds delay
  }
}
