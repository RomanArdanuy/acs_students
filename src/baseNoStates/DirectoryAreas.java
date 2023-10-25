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

    Partition exterior = new Partition("exterior", "...", building);

    allAreas.add(building);

    allAreas.add(basement);
    allAreas.add(groundfloor);
    allAreas.add(floor1);

    allAreas.add(exterior);


    Space stairs = new Space("stairs", "...", building);
    Space parking = new Space("parking", "...", basement);
    Space hall = new Space("hall", "...", groundfloor);
    Space room1 = new Space("room1", "...", groundfloor);
    Space room2 = new Space("room2", "...", groundfloor);
    Space room3 = new Space("room3", "...", floor1);
    Space corridor= new Space("corridor", "...", floor1);
    Space IT = new Space("IT", "...", floor1);

    allAreas.add(parking);
    //parking.addDoor();
    allAreas.add(stairs);
    allAreas.add(hall);
    allAreas.add(room1);
    allAreas.add(room2);
    allAreas.add(room3);
    allAreas.add(corridor);
    allAreas.add(IT);

    Door d1 = DirectoryDoors.findDoorById("D1");
    if (d1 != null) parking.addDoor(d1);

    if (d1 != null) stairs.addDoor(d1);


    Door d2 = DirectoryDoors.findDoorById("D2");
    if (d2 != null) {
      parking.addDoor(d2);
      hall.addDoor(d2);
    }

    Door d3 = DirectoryDoors.findDoorById("D3");
    if (d3 != null) hall.addDoor(d3);

    Door d4 = DirectoryDoors.findDoorById("D4");
    if (d4 != null) hall.addDoor(d4);

    Door d5 = DirectoryDoors.findDoorById("D5");
    if (d5 != null) {
      room1.addDoor(d5);
      hall.addDoor(d5);
    }

    Door d6 = DirectoryDoors.findDoorById("D6");
    if (d6 != null) {
      room2.addDoor(d6);
      hall.addDoor(d6);
    }

    Door d7 = DirectoryDoors.findDoorById("D7");
    if (d7 != null) corridor.addDoor(d7);

    Door d8 = DirectoryDoors.findDoorById("D8");
    if (d8 != null) {
      room3.addDoor(d8);
      corridor.addDoor(d8);
    }

    Door d9 = DirectoryDoors.findDoorById("D9");
    if (d9 != null) {
      IT.addDoor(d9);
      corridor.addDoor(d9);
    }


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
