package com.web.se_webshop.DB.BDObjects;

import com.web.se_webshop.BO.Model.AccountLogic.Permission;
import com.web.se_webshop.BO.Model.AccountLogic.User;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    /**
     * Adds a user to the database, checking for existing username or password before insertion.
     * @param user The User object to be added to the database.
     * @return True if the user was successfully added, false if the username or password already exists in the database.
     * @throws SQLException If a database error occurs during the operation.
     */

    public static boolean addUser(User user) throws SQLException {
        // SQL statements for checking user existence and inserting a new user.
        String sqlCheckExistence = "SELECT * FROM User WHERE username = ? OR password = ?";
        String sqlInsertUser = "INSERT INTO User (username, password, permission) VALUES (?, ?, ?)";

        PreparedStatement pstmtCheck = null;
        PreparedStatement pstmtInsert = null;

        try {
            // Check if the username or password already exists in the database.
            pstmtCheck = DBConnect.getConnection().prepareStatement(sqlCheckExistence);
            pstmtCheck.setString(1, user.getUsername());
            pstmtCheck.setString(2, user.getPassword());
            ResultSet resultSet = pstmtCheck.executeQuery();

            if (resultSet.next()) {
                return false; // Username or password already exists.
            }

            // Insert the new user into the database.
            pstmtInsert = DBConnect.getConnection().prepareStatement(sqlInsertUser);
            DBConnect.getConnection().setAutoCommit(false);
            pstmtInsert.setString(1, user.getUsername());
            pstmtInsert.setString(2, user.getPassword());
            pstmtInsert.setString(3, user.getPermission().toString());

            pstmtInsert.executeUpdate();

            DBConnect.getConnection().commit();

        } catch (SQLException e) {
            // Rollback transaction and throw an exception if a database error occurs.
            DBConnect.getConnection().rollback();
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
}
