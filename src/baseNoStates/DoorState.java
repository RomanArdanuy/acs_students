package baseNoStates;

public abstract class DoorState {
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

}
