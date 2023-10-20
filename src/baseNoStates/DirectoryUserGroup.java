package baseNoStates;
import java.util.ArrayList;
import java.util.List;


public class DirectoryUserGroup {
  private List<UserGroup> userGroups;

  public DirectoryUserGroup()
  {
    this.userGroups=new ArrayList<>();
  }

  public void addUserGroup(UserGroup userGroup)
  {
    if (!userGroups.contains(userGroup)) {
      userGroups.add(userGroup);
    }
  }

  public void removeUserGroup()
  {
    userGroups.removeIf(ug -> ug.getGroupName().equals(groupName));
  }




}
