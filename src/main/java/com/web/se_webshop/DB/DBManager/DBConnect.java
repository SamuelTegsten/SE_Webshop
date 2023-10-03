package com.web.se_webshop.DB.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnect implements DBManagerInterface{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/" + "sql_webshop"
                + "?UseClientEnc=UTF8";
    private static final String JDBC_USER = "estamuel";
    private static final String JDBC_PASSWORD = "reine.1234";

    private static Connection connection = null;

    public static boolean connectToDB() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("Connected!");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException();
        }
            return true;
    }


    public void disconnect() throws SQLException {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("You have successfully disconnected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e.getMessage(), e);
        }
    }


    public static Connection getConnection() {
        return connection;
    }
}



