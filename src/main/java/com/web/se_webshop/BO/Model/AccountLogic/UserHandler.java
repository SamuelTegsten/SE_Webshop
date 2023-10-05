package com.web.se_webshop.BO.Model.AccountLogic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.web.se_webshop.BO.Model.AccountLogic.User.getUserByAccount;

public class UserHandler {
    private static List<User> userList = new ArrayList<>();

    public static void addUser(User user) {
        userList.add(user);
    }

    public static List<User> getAllUsers() {
        return userList;
    }

    public static Permission getUser(String username, String password) throws SQLException {
       return getUserByAccount(username,password);
    }

    public static void removeUser(User user) {
        userList.remove(user);
    }
}
