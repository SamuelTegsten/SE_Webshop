package com.web.se_webshop.BO.Handler.UserHandler;

import com.web.se_webshop.BO.Model.AccountModel.User;

import java.util.ArrayList;
import java.util.List;

public class userHandler {
    private static List<User> userList = new ArrayList<>();

    public static void addUser(User user) {
        userList.add(user);
    }

    public static List<User> getAllUsers() {
        return userList;
    }

    public static User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void removeUser(User user) {
        userList.remove(user);
    }
}
