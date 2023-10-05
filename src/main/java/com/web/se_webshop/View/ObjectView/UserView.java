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
public class UserView {

    // Fields to store username and permission for a UserView object
    private String username;
    private Permission permission;

    /**
     * Constructor for creating a UserView object with username and permission.
     *
     * @param username   The username of the user.
     * @param permission The permission level of the user.
     */
    protected UserView(String username, Permission permission) {
        this.username = username;
        this.permission = permission;
    }

    /**
     * Static method to import all users as UserView objects from the database.
     *
     * @return An ArrayList of UserView objects representing all users.
     * @throws SQLException If there is an issue with database access.
     */
    public static ArrayList<UserView> importAllUsers() throws SQLException {
        // Retrieve a collection of User objects from the database
        Collection<User> userList = getAllUsers();

        // Initialize an ArrayList to store UserView objects
        ArrayList<UserView> listOfAllUserView = new ArrayList<>(userList.size());

        // Convert each User object to a UserView object and add it to the list
        for (User user : userList) {
            listOfAllUserView.add(new UserView(user.getUsername(), user.getPermission()));
        }
        return listOfAllUserView;
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
    @Override
    public String toString() {
        return "UserView{" +
                "username='" + username + '\'' +
                ", permission=" + permission +
                '}';
    }
}
