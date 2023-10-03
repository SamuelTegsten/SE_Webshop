package com.web.se_webshop.DB.DBManager;

import java.sql.Connection;
import java.sql.SQLException;

public class DBDisconnect {
    public void disconnect() throws SQLException {
        Connection connection = DBConnect.getConnection();
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
}
