package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
The class unlocked is part of the state design in our project, as it inherits the methods from
the doorState class. In this class we implement all the abstract methods inherited specifically
for a door that is unlocked, meaning it can be opened, closed, and locked, but never unlocked
 */
public class Unlocked extends DoorState {

    private static final Logger logger = LoggerFactory.getLogger(baseNoStates.Unlocked.class);

    public Unlocked(Door door) {
        super(door);
        this.name = "unlocked";
        logger.debug("Door state set to unlocked");
    }

    public void open() {
        if (door.isClosed()) {
            door.setClosed(false);
            logger.info("Door opened");
        } else {
            logger.warn("Attempt to open when door is already unlocked");
        }
    }

    public void close() {
        if (door.isClosed()) {
            logger.warn("Attempt to close an already closed door");
        } else {
            door.setClosed(true);
            logger.info("Door closed");
        }
    }

    public void lock() {
        if (door.isClosed()) {
            door.setState(new Locked(door));
            logger.info("Door locked");
        } else {
            logger.warn("Attempt to lock when door is open");
        }
    }

    public void unlock() {
        logger.info("Attempt to unlock an already unlocked door");
    }

    @Override
    public void unlockShortly() {
        // Either ignore or set a timer to lock the door after a short duration
        logger.debug("Unlock shortly called");
    }
}
