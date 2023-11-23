package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
DoorState is a class applying the state design pattern. For each door, there is five states
these can be set to, controlling if anyone can get through the door, or if a specific group
of users can get through. The 5 abstract methods will be inherited and implemented by the
classes for the states locked and unlocked.
*/
public abstract class DoorState {

  //

  public Door door;
  String name;

  public DoorState(Door door)
  {
    this.door=door;
    this.name="unlocked";
  }

  public abstract void open();
  public abstract void close();
  public abstract void lock();
  public abstract void unlock();
  public abstract void unlockShortly();


}
