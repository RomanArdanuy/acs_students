package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

public class DirectoryAreas {

  private static final Logger logger = LoggerFactory.getLogger(DirectoryAreas.class);

  private static ArrayList<Area> allAreas = new ArrayList<>();
  private static Partition root;
  /*
  Para convertir esta clase para que siga el patron Singleton, añadiremos un campo estático,
  un constructor privado, un metodo estatico publico getInstance
  */
  private static DirectoryAreas instance = null;

  private DirectoryAreas() {
    logger.debug("Initializing DirectoryAreas");
    allAreas = new ArrayList<>();
    makeAreas();
  }

  public static DirectoryAreas getInstance() {
    if (instance == null) {
      logger.info("DirectoryAreas instance created");
      instance = new DirectoryAreas();
    }
    return instance;
  }

  private void makeAreas() {
    logger.debug("Creating areas");

    Partition building = new Partition("building", "...", null);
    root = building;
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
    Space corridor = new Space("corridor", "...", floor1);
    Space IT = new Space("IT", "...", floor1);

    allAreas.add(parking);
    allAreas.add(stairs);
    allAreas.add(hall);
    allAreas.add(room1);
    allAreas.add(room2);
    allAreas.add(room3);
    allAreas.add(corridor);
    allAreas.add(IT);

    // Aquí se añaden las puertas a los espacios, como en tu código original
    // ...

    logger.debug("Areas created successfully");
  }

  public static Area findAreaById(String id) {
    logger.debug("Searching for area with ID: {}", id);
    for (Area area : allAreas) {
      if (area.getId().equals(id)) {
        logger.debug("Area found: {}", id);
        return area;
      }
    }
    logger.warn("No area found with ID: {}", id);
    return null; // Return null if no area with the given ID is found
  }

  // ... (resto de la clase)

}
