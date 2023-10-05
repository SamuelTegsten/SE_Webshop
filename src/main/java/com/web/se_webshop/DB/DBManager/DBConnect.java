package com.web.se_webshop.DB.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Manages the database connection to MySQL.
 */
public class DBConnect {
    // JDBC URL for the database connection
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/" + "sql_webshop"
            + "?UseClientEnc=UTF8";

    // Database username and password
    private static final String JDBC_USER = "estamuel";
    private static final String JDBC_PASSWORD = "reine.1234";

    // Connection object for managing the database connection
    private Connection connection = null;

    // Singleton instance of DBConnect
    private static DBConnect instance = null;

    /**
     * Private constructor to create a new instance of DBConnect and establish a database connection.
     */
    private DBConnect() {
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database using the specified URL, username, and password
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Print a message to indicate a successful connection
            System.out.println("Connected to MySQL!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the singleton instance of DBConnect.
     *
     * @return The DBConnect instance.
     */
    private static DBConnect getInstance() {
        if (instance == null)
            instance = new DBConnect();
        return instance;
    }

    /**
     * Get the database connection.
     *
     * @return The Connection object representing the database connection.
     */
    public static Connection getConnection() {
        return getInstance().connection;
    }
}
