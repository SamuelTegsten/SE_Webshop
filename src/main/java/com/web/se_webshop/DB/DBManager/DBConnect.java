package com.web.se_webshop.DB.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/" + "sql_webshop"
                + "?UseClientEnc=UTF8";
    private static final String JDBC_USER = "estamuel";
    private static final String JDBC_PASSWORD = "reine.1234";

    private Connection connection = null;
    private static DBConnect instance = null;

    private static DBConnect getInstance(){
        if(instance == null)
            instance = new DBConnect();
        return instance;
    }

    private DBConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("Connected!");
        } catch (Exception e){e.printStackTrace();}
    }
    public static Connection getConnection() {
        return getInstance().connection;
    }
}



