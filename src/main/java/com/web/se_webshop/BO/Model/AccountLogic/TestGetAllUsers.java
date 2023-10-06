package com.web.se_webshop.BO.Model.AccountLogic;

import java.sql.SQLException;

import static com.web.se_webshop.BO.Model.AccountLogic.User.getAllUsers;
import static com.web.se_webshop.BO.Model.AccountLogic.UserHandler.getUsers;
import static com.web.se_webshop.DB.BDObjects.DbUser.findAllUserDB;

public class TestGetAllUsers {
    public static void main(String[] args) throws SQLException {
        System.out.println(getUsers());
    }
}
