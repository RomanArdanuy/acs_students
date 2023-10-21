package baseNoStates;

import java.util.ArrayList;

import static baseNoStates.DirectoryDoors.allDoors;

public class DirectoryAreas {

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

    allAreas.add(building);
    allAreas.add(basement);
    allAreas.add(groundfloor);
    allAreas.add(floor1);
    allAreas.add(stairs);
    allAreas.add(exterior);



    Space parking = new Space("parking", "...", basement);
    Space hall = new Space("hall", "...", groundfloor);
    Space room1 = new Space("room1", "...", groundfloor);
    Space room2 = new Space("room2", "...", groundfloor);
    Space room3 = new Space("room3", "...", floor1);
    Space corridor= new Space("corridor", "...", floor1);
    Space IT = new Space("IT", "...", floor1);

    allAreas.add(parking);
    allAreas.add(hall);
    allAreas.add(room1);
    allAreas.add(room2);
    allAreas.add(room3);
    allAreas.add(corridor);
    allAreas.add(IT);
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
