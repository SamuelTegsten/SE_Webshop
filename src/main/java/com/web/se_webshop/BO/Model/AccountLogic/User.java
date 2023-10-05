package com.web.se_webshop.BO.Model.AccountLogic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static com.web.se_webshop.DB.BDObjects.DbUser.*;

/**
 * Represents a user in the application with properties like username, password, and permission level.
 */
public class User {

    // Fields to store username, password, and permission for a User object
    private String username;
    private String password;
    private Permission permission;

    /**
     * Constructor for creating a User object with username, password, and permission.
     *
     * @param username   The username of the user.
     * @param password   The password of the user.
     * @param permission The permission level of the user.
     */
    protected User(String username, String password, Permission permission) {
        this.username = username;
        this.password = password;
        this.permission = permission;
    }

    /**
     * Static method to retrieve a user's permission based on username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The permission level of the user.
     * @throws SQLException If there is an issue with database access.
     */
    public static Permission getUserByAccount(String username, String password) throws SQLException {
        return findAccountByDetails(username, password);
    }

    /**
     * Static method to add a user to the database based on User object.
     *
     * @param user The User object to add to the database.
     * @return True if the user is successfully added, false otherwise.
     * @throws SQLException If there is an issue with database access.
     */
    public static boolean addUserByDetails(User user) throws SQLException {
        return addUserDB(user);
    }

    /**
     * Static method to remove a user from the database based on username.
     *
     * @param username The username of the user to remove.
     * @return True if the user is successfully removed, false otherwise.
     * @throws SQLException If there is an issue with database access.
     */
    public static boolean removeUserByUsername(String username) throws SQLException {
        return removeUserDB(username);
    }

    /**
     * Static method to remove an admin from the database based on username and password.
     *
     * @param username The username of the admin to remove.
     * @param password The password of the admin.
     * @return True if the admin is successfully removed, false otherwise.
     * @throws SQLException If there is an issue with database access.
     */
    public static boolean removeAdminByDetails(String username, String password) throws SQLException {
        return removeAdminDB(username, password);
    }

    /**
     * Static method to retrieve a collection of all users from the database.
     *
     * @return A collection of User objects representing all users.
     * @throws SQLException If there is an issue with database access.
     */
    public static Collection<User> getAllUsers() throws SQLException {
        return findAllUserDB();
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
     * Setter for updating the username.
     *
     * @param username The new username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for retrieving the password.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for updating the password.
     *
     * @param password The new password to set.
     */
    public void setPassword(String password) {
        this.password = password;
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
     * Setter for updating the permission.
     *
     * @param permission The new permission level to set.
     */
    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    /**
     * Override the toString() method to provide a formatted string representation of the User object.
     *
     * @return A string representation of the User object.
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                '}';
    }
}
