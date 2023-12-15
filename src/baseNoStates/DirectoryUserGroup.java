package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class DirectoryUserGroup {
    private static final Logger logger = LoggerFactory.getLogger(DirectoryUserGroup.class);
    private static DirectoryUserGroup instance = null;
    private List<UserGroup> userGroups;

    private DirectoryUserGroup() {
        this.userGroups = new ArrayList<>();
        initializeDefaultUserGroup();
        logger.info("DirectoryUserGroup initialized with default user groups");
    }

    public static DirectoryUserGroup getInstance() {
        if (instance == null) {
            instance = new DirectoryUserGroup();
            logger.debug("New instance of DirectoryUserGroup created");
        }
        return instance;
    }

    private void initializeDefaultUserGroup() {
        try {
            UserGroup adminGroup = new UserGroup("admin");
            UserGroup managersGroup = new UserGroup("managers");
            UserGroup employeesGroup = new UserGroup("employees");

            for (Door door : DirectoryDoors.getAllDoors()) {
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

                // Employees permissions
                if (!door.getId().equals("D1") && (!door.getId().equals("D2"))) {
                    employeesGroup.grantPermission("unlockshortly_" + door.getId());
                    employeesGroup.grantPermission("open_" + door.getId());
                    employeesGroup.grantPermission("close_" + door.getId());
                }
            }

            userGroups.add(adminGroup);
            userGroups.add(managersGroup);
            userGroups.add(employeesGroup);

            logger.debug("Default user groups added");
        } catch (Exception e) {
            logger.error("Error initializing default user groups: {}", e.getMessage());
        }
    }

    public void addUserGroup(UserGroup userGroup) {
        if (!userGroups.contains(userGroup)) {
            userGroups.add(userGroup);
            logger.info("User group added: {}", userGroup.getGroupName());
        } else {
            logger.warn("Attempted to add a duplicate user group: {}", userGroup.getGroupName());
        }
    }

    public void removeUserGroup(String groupName) {
        boolean removed = userGroups.removeIf(ug -> ug.getGroupName().equals(groupName));
        if (removed) {
            logger.info("User group removed: {}", groupName);
        } else {
            logger.warn("Attempted to remove a non-existent user group: {}", groupName);
        }
    }

    public UserGroup findUserGroupByName(String groupName) {
        for (UserGroup userGroup : userGroups) {
            if (userGroup.getGroupName().equals(groupName)) {
                logger.debug("User group found: {}", groupName);
                return userGroup;
            }
        }
        logger.warn("No user group found with name: {}", groupName);
        return null;
    }

    public List<UserGroup> listAllUserGroups() {
        logger.info("Listing all user groups");
        return new ArrayList<>(userGroups);
    }

    @Override
    public String toString() {
        return "DirectoryUserGroups{" +
            "userGroups=" + userGroups +
            '}';
    }
}
