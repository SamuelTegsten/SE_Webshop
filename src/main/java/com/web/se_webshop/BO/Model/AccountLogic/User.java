package com.web.se_webshop.BO.Model.AccountLogic;

import java.sql.SQLException;

import static com.web.se_webshop.DB.BDObjects.DbUser.addUserDB;
import static com.web.se_webshop.DB.BDObjects.DbUser.findAccountByDetails;

public class User {
    private String username;
    private String password;
    private Permission permission;

    protected User(String username, String password, Permission permission) {
        this.username = username;
        this.password = password;
        this.permission = permission;
    }

    public static Permission getUserByAccount(String username, String password) throws SQLException {
        return findAccountByDetails(username, password);
    }

    public static boolean addUserByDetails(User user) throws SQLException {
        return addUserDB(user);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                '}';
    }
}

