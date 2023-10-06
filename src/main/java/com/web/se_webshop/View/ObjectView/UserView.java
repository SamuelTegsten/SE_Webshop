package com.web.se_webshop.View.ObjectView;

import com.web.se_webshop.BO.Model.AccountLogic.Permission;
import com.web.se_webshop.BO.Model.AccountLogic.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static com.web.se_webshop.BO.Model.AccountLogic.User.getAllUsers;

/**
 * Represents a view of user data, providing methods to import and manipulate user information.
 */
public class UserView implements Comparable<UserView>{

    // Fields to store username and permission for a UserView object
    private String username;
    private Permission permission;

    /**
     * Constructor for creating a UserView object with username and permission.
     *
     * @param username   The username of the user.
     * @param permission The permission level of the user.
     */
    public UserView(String username, Permission permission) {
        this.username = username;
        this.permission = permission;
    }

    /**
     * Getter for retrieving the username.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter for retrieving the permission.
     *
     * @return The permission level of the user.
     */
    public Permission getPermission() {
        return permission;
    }

    /**
     * Setter for updating the username.
     *
     * @param username The new username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter for updating the permission.
     *
     * @param permission The new permission level to set.
     */
    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    /**
     * Override the toString() method to provide a formatted string representation of the UserView object.
     *
     * @return A string representation of the UserView object.
     */

    public int getPermissionLevel() {
        // Add logic to determine the permission level based on your data
        // For example, assuming permission is stored as a string:
        if ("ADMIN".equals(permission)) {
            return 1;
        } else if ("STAFF".equals(permission)) {
            return 2;
        } else {
            return 3; // USER or other permissions
        }
    }

    @Override
    public int compareTo(UserView otherUser) {
        // Compare users based on their permission levels
        return Integer.compare(this.getPermissionLevel(), otherUser.getPermissionLevel());
    }

    @Override
    public String toString() {
        return "UserView{" +
                "username='" + username + '\'' +
                ", permission=" + permission +
                '}';
    }
}
