package com.web.se_webshop.BO.Model.AccountLogic;

import com.web.se_webshop.View.ObjectView.UserView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.web.se_webshop.BO.Model.AccountLogic.User.*;

/**
 * Handles operations related to user management and permissions.
 */
public class UserHandler {
    
    /**
     * Adds a new user with the specified username, password, and permission.
     *
     * @param username   The username of the new user.
     * @param password   The password of the new user.
     * @param permission The permission level of the new user.
     * @return True if the user is successfully added, false otherwise.
     * @throws SQLException If there is an issue with database access.
     */
    public static boolean addUser(String username, String password, Permission permission) throws SQLException {
        User user = new User(username, password, permission);
        return addUserByDetails(user);
    }

    /**
     * Removes a user with the specified username.
     *
     * @param username The username of the user to be removed.
     * @return True if the user is successfully removed, false otherwise.
     * @throws SQLException If there is an issue with database access.
     */
    public static boolean removeUser(String username) throws SQLException {
        return removeUserByUsername(username);
    }

    /**
     * Removes an admin with the specified username and password.
     *
     * @param username The username of the admin to be removed.
     * @param password The password of the admin.
     * @return True if the admin is successfully removed, false otherwise.
     * @throws SQLException If there is an issue with database access.
     */
    public static boolean removeAdmin(String username, String password) throws SQLException {
        return removeAdminByDetails(username, password);
    }

    /**
     * Static method to import all users as UserView objects from the database.
     *
     * @return An ArrayList of UserView objects representing all users.
     * @throws SQLException If there is an issue with database access.
     */
    public static ArrayList<UserView> getUsers() throws SQLException {
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
     * Retrieves the permission of a user based on the provided username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The permission level of the user, or null if the user does not exist or the password is incorrect.
     * @throws SQLException If there is an issue with database access.
     */
    public static Permission getUser(String username, String password) throws SQLException {
        Permission userPermission = getUserByAccount(username, password);
        if (userPermission != null) {
            return userPermission;
        } else {
            return null;
        }
    }
}
