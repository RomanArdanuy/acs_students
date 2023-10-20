package baseNoStates;

import java.util.ArrayList;
import java.util.List;

public class DirectoryUserGroup {
    private List<UserGroup> userGroups;

    public DirectoryUserGroup() {
        this.userGroups = new ArrayList<>();
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
