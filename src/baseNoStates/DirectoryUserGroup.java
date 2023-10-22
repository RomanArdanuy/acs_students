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
        UserGroup adminGroup = new UserGroup("admin");
        UserGroup managersGroup = new UserGroup("managers");
        UserGroup employeesGroup  = new UserGroup("employees");

        for (Door door : DirectoryDoors.getAllDoors()) {
            // Employees permissions
            if (!door.getId().equals("parking")) {
                employeesGroup.grantPermission("unlockshortly_" + door.getId());
            }
            // Admin permissions
            adminGroup.grantPermission("open_" + door.getId());
            adminGroup.grantPermission("close_" + door.getId());
            adminGroup.grantPermission("lock_" + door.getId());
            adminGroup.grantPermission("unlock_" + door.getId());

            // Managers permissions
            managersGroup.grantPermission("open_" + door.getId());
            managersGroup.grantPermission("close_" + door.getId());
            managersGroup.grantPermission("lock_" + door.getId());
            managersGroup.grantPermission("unlock_" + door.getId());
        }

        userGroups.add(adminGroup);
        userGroups.add(managersGroup);
        userGroups.add(employeesGroup);
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
