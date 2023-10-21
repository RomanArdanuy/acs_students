package baseNoStates;

import java.util.ArrayList;
import java.util.List;

public class DirectoryUserGroup {
    private List<UserGroup> userGroups;

    public DirectoryUserGroup() {
        this.userGroups = new ArrayList<>();
        initializeDefaultUserGroup();
    }

    private void initializeDefaultUserGroup()
    {
        UserGroup adminGroup = new UserGroup("Admin");
        adminGroup.grantPermission("open_*");
        adminGroup.grantPermission("close_*");
        adminGroup.grantPermission("lock_*");
        adminGroup.grantPermission("unlock_*");
        userGroups.add(adminGroup);


        UserGroup employeeGroup = new UserGroup("Employee");
        employeeGroup.grantPermission("open_D1");
        employeeGroup.grantPermission("close_D1");
        employeeGroup.grantPermission("open_D2");
        employeeGroup.grantPermission("close_D2");
        userGroups.add(employeeGroup);
    }


    public void addUserGroup(UserGroup userGroup) {
        if (!userGroups.contains(userGroup)) {
            userGroups.add(userGroup);
        }
    }

    public void removeUserGroup(String groupName) {
        userGroups.removeIf(ug -> ug.getGroupName().equals(groupName));
    }

    public UserGroup findUserGroupByName(String groupName) {
        for (UserGroup userGroup : userGroups) {
            if (userGroup.getGroupName().equals(groupName)) {
                return userGroup;
            }
        }
        return null;
    }

    public List<UserGroup> listAllUserGroups() {
        return new ArrayList<>(userGroups);
    }

    @Override
    public String toString() {
        return "DirectoryUserGroups{" +
                "userGroups=" + userGroups +
                '}';
    }
}
