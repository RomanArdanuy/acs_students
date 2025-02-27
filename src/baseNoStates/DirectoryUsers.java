package baseNoStates;

import java.util.ArrayList;


/*
DirectoryUsers is a class which will be essential for the organisation and creation of the different User ,
where we will create every user which will acces and use our software, giving them the caracteristics they have
including the group where they will be asigned.
We also have a method to obtain a User by his ID, given in its creation.
*/
public final class DirectoryUsers {
  private static final ArrayList<User> users = new ArrayList<>();
  private UserGroup userGroup;

  public static void makeUsers() {
    //TODO: make user groups according to the specifications in the comments, because
    // now all are the same
    DirectoryUserGroup directory = DirectoryUserGroup.getInstance();
    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    users.add(new User("Bernat", "12345"));
    users.add(new User("Blai", "77532"));



    // employees :
    // Sep. 1 2023 to Mar. 1 2024
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    UserGroup employeesGroup = directory.findUserGroupByName("employees");
    User ernest = new User("Ernest", "74984");
    User eulalia = new User("Eulalia", "43295");
    if (employeesGroup != null) {
      ernest.setUserGroup(employeesGroup);
      eulalia.setUserGroup(employeesGroup);
    }
    users.add(ernest);
    users.add(eulalia);



    // managers :
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    UserGroup managersGroup = directory.findUserGroupByName("managers");
    User manel = new User("Manel", "95783");
    User marta = new User("Marta", "05827");
    if (managersGroup != null) {
      manel.setUserGroup(managersGroup);
      marta.setUserGroup(managersGroup);
    }
    users.add(manel);
    users.add(marta);

    // admin :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces

    UserGroup adminGroup = directory.findUserGroupByName("admin");
    User ana = new User("Ana", "11343");
    ana.setUserGroup(adminGroup);
    if (adminGroup != null) {
      ana.setUserGroup(adminGroup);
    }
    users.add(ana);
  }

  public static User findUserByCredential(String credential) {
    for (User user : users) {
      if (user.getCredential().equals(credential)) {
        return user;
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null; // otherwise we get a Java error
  }

  public void setUserGroup(UserGroup userGroup) {
    this.userGroup = userGroup;
  }

}
