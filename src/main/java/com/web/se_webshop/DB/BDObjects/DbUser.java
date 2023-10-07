package com.web.se_webshop.DB.BDObjects;

import com.web.se_webshop.BO.Model.AccountLogic.Permission;
import com.web.se_webshop.BO.Model.AccountLogic.User;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class extends the User class and provides functionality for CRUD operations on the database.
 */
public class DbUser extends User {

    /**
     * Constructor to create a DbUser object.
     * @param username   The username of the user.
     * @param password   The password of the user.
     * @param permission The permission level of the user.
     */

    protected DbUser(String username, String password, Permission permission) {
        super(username, password, permission);
    }

    private static Connection connection = DBConnect.getConnection();

    /**
     * Adds a user to the database, checking for existing username or password before insertion.
     * @param user The User object to be added to the database.
     * @return True if the user was successfully added, false if the username or password already exists in the database.
     * @throws SQLException If a database error occurs during the operation.
     */

    public static boolean addUserDB(User user) throws SQLException {
        // SQL statements for checking user existence and inserting a new user.
        String sqlCheckExistence = "SELECT * FROM User WHERE username = ? OR password = ?";
        String sqlInsertUser = "INSERT INTO User (username, password, permission) VALUES (?, ?, ?)";

        PreparedStatement pstmtCheck = null;
        PreparedStatement pstmtInsert = null;

        try {
            // Check if the username or password already exists in the database.
            pstmtCheck = connection.prepareStatement(sqlCheckExistence);
            pstmtCheck.setString(1, user.getUsername());
            pstmtCheck.setString(2, user.getPassword());
            ResultSet resultSet = pstmtCheck.executeQuery();

            if (resultSet.next()) {
                return false; // Username or password already exists.
            }

            // Insert the new user into the database.
            pstmtInsert = connection.prepareStatement(sqlInsertUser);
            connection.setAutoCommit(false);
            pstmtInsert.setString(1, user.getUsername());
            pstmtInsert.setString(2, user.getPassword());
            pstmtInsert.setString(3, user.getPermission().toString());

            pstmtInsert.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            // Rollback transaction and throw an exception if a database error occurs.
            connection.rollback();
            throw new SQLException(e);
        } finally {
            // Close prepared statements to release resources.
            if (pstmtCheck != null) {
                pstmtCheck.close();
            }
            if (pstmtInsert != null) {
                pstmtInsert.close();
            }
        }
        return true; // User successfully added to the database.
    }

    /**
     * Finds a user account in the database by username and password and returns the user's permission.
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The permission of the user if found, null if the user is not found.
     * @throws SQLException If a database error occurs during the operation.
     */
    public static Permission findAccountByDetails(String username, String password) throws SQLException {
        String sqlFindUser = "SELECT permission FROM User WHERE username = ? AND password = ?";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            pstmt = connection.prepareStatement(sqlFindUser);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                // User found, return their permission.
                String permissionStr = resultSet.getString("permission");
                return Permission.valueOf(permissionStr);
            } else {
                // User not found.
                return null;
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            // Close prepared statement and result set to release resources.
            if (resultSet != null) {
                resultSet.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    /**
     * Removes a user from the database by username, can't remove an Admin.
     * @param username The username of the user to be removed.
     * @return True if the user was successfully removed, false if the user was not found.
     * @throws SQLException If a database error occurs during the operation.
     */
    public static boolean removeUserDB(String username) throws SQLException {
        String sqlCheckPermission = "SELECT permission FROM User WHERE username = ?";
        String sqlRemoveUser = "DELETE FROM User WHERE username = ?";
        PreparedStatement pstmtCheck = null;
        PreparedStatement pstmtRemove = null;

        try {
            // Check the user's permission first
            pstmtCheck = connection.prepareStatement(sqlCheckPermission);
            connection.setAutoCommit(false);
            pstmtCheck.setString(1, username);
            ResultSet resultSet = pstmtCheck.executeQuery();

            if (resultSet.next()) {
                String permission = resultSet.getString("permission");

                // Check if the user has ADMIN permission
                if ("ADMIN".equals(permission)) {
                    // User has ADMIN permission, do not remove.
                    return false;
                }

                // User has permission other than ADMIN, proceed with removal
                pstmtRemove = connection.prepareStatement(sqlRemoveUser);
                pstmtRemove.setString(1, username);
                int rowsAffected = pstmtRemove.executeUpdate();

                if (rowsAffected > 0) {
                    // User successfully removed from the database.
                    connection.commit();
                    connection.setAutoCommit(true);
                    return true;
                } else {
                    // User not found.
                    return false;
                }
            } else {
                // User not found.
                return false;
            }
        } catch (SQLException e) {
            // Rollback transaction and throw an exception if a database error occurs.
            connection.rollback();
            throw new SQLException(e);
        } finally {
            // Close prepared statements to release resources.
            if (pstmtCheck != null) {
                pstmtCheck.close();
            }
            if (pstmtRemove != null) {
                pstmtRemove.close();
            }
        }
    }


    /**
     * Removes an admin from the database by username and password.
     * @param username The username of the admin to be removed.
     * @param password The password of the admin to be removed.
     * @return True if the admin was successfully removed, false if the admin was not found.
     * @throws SQLException If a database error occurs during the operation.
     */
    public static boolean removeAdminDB(String username, String password) throws SQLException {
        String sqlRemoveAdmin = "DELETE FROM User WHERE username = ? AND password = ?";
        PreparedStatement pstmt = null;

        try {
            pstmt = connection.prepareStatement(sqlRemoveAdmin);
            connection.setAutoCommit(false);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                // Admin successfully removed from the database.
                connection.commit();
                connection.setAutoCommit(true);
                return true;
            } else {
                // Admin not found.
                return false;
            }
        } catch (SQLException e) {
            // Rollback transaction and throw an exception if a database error occurs.
            connection.rollback();
            throw new SQLException(e);
        } finally {
            // Close prepared statement to release resources.
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    /**
     * Finds all users in the database and returns a collection of User objects.
     *
     * @return A collection containing all users in the database.
     * @throws SQLException If a database error occurs during the operation.
     */
    public static Collection<User> findAllUserDB() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        String sqlFindAllUsers = "SELECT username, password, permission FROM User";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            pstmt = connection.prepareStatement(sqlFindAllUsers);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String permissionStr = resultSet.getString("permission");
                Permission permission = Permission.valueOf(permissionStr);

                User user = new DbUser(username, password, permission);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            // Close prepared statement and result set to release resources.
            if (resultSet != null) {
                resultSet.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
        return (Collection<User>) users.clone();
    }
}
