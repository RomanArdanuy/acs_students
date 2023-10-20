package baseNoStates;
import java.util.ArrayList;
import java.util.List;

public class UserGroup {
  private String groupName;
  private List<User> users;
  private List<String> permissions;

  public UserGroup(String groupName) {
    this.groupName = groupName;
    this.users = new ArrayList<>();
    this.permissions = new ArrayList<>();
  }

  public void addUser(User user)
  {
    if(!users.contains(user))
    {
      users.add(user);
    }
  }

  public String getGroupName()
  {
    return groupName;
  }



  public void  removeUser(User user)
  {
    users.remove(user);
  }
  public boolean hasUser(User user) {
    return users.contains(user);
  }

  public void grantPermission(String permission) {
    if (!permissions.contains(permission)) {
      permissions.add(permission);
    }
  }

  public void revokePermission(String permission) {
    permissions.remove(permission);
  }

  public boolean hasPermission(String permission) {
    return permissions.contains(permission);
  }

  @Override
  public String toString() {
    return "UserGroup{" +
        "groupName='" + groupName + '\'' +
        ", users=" + users +
        ", permissions=" + permissions +
        '}';
  }

}
