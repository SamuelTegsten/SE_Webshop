package com.web.se_webshop.DB.DBManager;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Manages the disconnection from the database.
 */
public class DBDisconnect {
    /**
     * Disconnects from the database by closing the connection.
     *
     * @throws SQLException If an error occurs while closing the database connection.
     */
    public void disconnect() throws SQLException {
        // Get the database connection from the DBConnect class
        Connection connection = DBConnect.getConnection();
        try {
            if (connection != null) {
                // Close the database connection
                connection.close();

                // Print a message to indicate a successful disconnection
                System.out.println("You have successfully disconnected");
            }
        } catch (SQLException e) {
            // Print the stack trace for any SQL-related exceptions
            e.printStackTrace();

            // Rethrow the SQLException with a custom message
            throw new SQLException(e.getMessage(), e);
        }
    }
}
