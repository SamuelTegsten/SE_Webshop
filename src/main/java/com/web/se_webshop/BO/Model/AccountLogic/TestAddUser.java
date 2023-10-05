package com.web.se_webshop.BO.Model.AccountLogic;

import com.web.se_webshop.DB.BDObjects.DbUser;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.SQLException;

public class TestAddUser {
    public static void main(String[] args) throws SQLException {
        System.out.println(DBConnect.getConnection());
        if(DbUser.addUser(new User("Maria", "Ukkonen", Permission.STAFF))){
            System.out.println("USER ADDED");
        } else {
            System.out.println("USERNAME OR PASSWORD ALREADY EXISTS");
        }
    }
}
