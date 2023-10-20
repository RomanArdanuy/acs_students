package baseNoStates;

public class User {
  private final String name;
  private final String credential;
  private UserGroup userGroup;

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }

  public boolean hasPermission(String requiredPermission) {
    if (userGroup != null) {
      return userGroup.hasPermission(requiredPermission);
    }
    return false;
  }

  public UserGroup getUserGroup() {
    return userGroup;
  }

  public void setUserGroup(UserGroup userGroup) {
    this.userGroup = userGroup;
  }

}
