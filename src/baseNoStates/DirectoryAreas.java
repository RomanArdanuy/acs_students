package baseNoStates;

import java.util.ArrayList;

public class DirectoryAreas {
  private static ArrayList<Door> allDoors;
  private static ArrayList<Area> allAreas = new ArrayList<>();

  private static Partition root;

  public static void makeAreas()
  {

    Partition building = new Partition("building", "...", null);
    root=building;
    Partition basement = new Partition("basement", "...", building);
    Partition groundfloor = new Partition("groundfloor", "...", building);
    Partition floor1 = new Partition("floor1", "...", building);
    Partition stairs = new Partition("basement", "...", building);
    Partition exterior = new Partition("exterior", "...", building);

    Space parking = new Space("parking", "...", basement);
    Space hall = new Space("hall", "...", groundfloor);
    Space room1 = new Space("room1", "...", groundfloor);
    Space room2 = new Space("room2", "...", groundfloor);
    Space room3 = new Space("room3", "...", floor1);
    Space corridor= new Space("corridor", "...", floor1);
    Space IT = new Space("IT", "...", floor1);

    Door d1 = new Door("D1", exterior, parking);
    Door d2 = new Door("D2", stairs, parking);
    Door d3 = new Door("D3", exterior , hall);
    Door d4 = new Door("D4", stairs, hall);
    Door d5 = new Door("D5", room1, hall);
    Door d6 = new Door("D6", hall, room2);
    Door d7 = new Door("D7", stairs, corridor);
    Door d8 = new Door("D8", room3, corridor);
    Door d9 = new Door("D9", corridor, IT);


  }

  public static Door findDoorById(String id)
  {
    for (Door door : allDoors) {
      if (door.getId().equals(id)) {
        return door;
      }
    }
    return null;
  }

  public static Area findAreaById(String id) {
    for (Area area : allAreas) {
      if (area.getId().equals(id)) {
        return area;
      }
    }
    return null; // Return null if no area with the given ID is found
  }


}
