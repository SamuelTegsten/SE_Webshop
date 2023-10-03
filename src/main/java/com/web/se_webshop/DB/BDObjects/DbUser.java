package com.web.se_webshop.DB.BDObjects;

import com.web.se_webshop.BO.Model.AccountLogic.Permission;
import com.web.se_webshop.BO.Model.AccountLogic.User;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUser extends User {
    protected DbUser(String username, String password, Permission permission) {
        super(username, password, permission);
    }

    public static boolean addUser(User user) throws SQLException {
        String sqlCheckExistence = "SELECT * FROM User WHERE username = ? OR password = ?";
        String sqlInsertUser = "INSERT INTO User (username, password, permission) VALUES (?, ?, ?)";

        PreparedStatement pstmtCheck = null;
        PreparedStatement pstmtInsert = null;

        try {
            pstmtCheck = DBConnect.getConnection().prepareStatement(sqlCheckExistence);
            pstmtCheck.setString(1, user.getUsername());
            pstmtCheck.setString(2, user.getPassword());
            ResultSet resultSet = pstmtCheck.executeQuery();

            if (resultSet.next()) {
                return false;
            }

            pstmtInsert = DBConnect.getConnection().prepareStatement(sqlInsertUser);
            DBConnect.getConnection().setAutoCommit(false);
            pstmtInsert.setString(1, user.getUsername());
            pstmtInsert.setString(2, user.getPassword());
            pstmtInsert.setString(3, user.getPermission().toString());

            pstmtInsert.executeUpdate();

            DBConnect.getConnection().commit();

        } catch (SQLException e) {
            DBConnect.getConnection().rollback();
            throw new SQLException(e);
        } finally {
            if (pstmtCheck != null) {
                pstmtCheck.close();
            }
            if (pstmtInsert != null) {
                pstmtInsert.close();
            }
        }
        return true;
    }
}

