package com.web.se_webshop.BO.Model.AccountLogic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.web.se_webshop.BO.Model.AccountLogic.User.addUserByDetails;
import static com.web.se_webshop.BO.Model.AccountLogic.User.getUserByAccount;

public class UserHandler {
    private static List<User> userList = new ArrayList<>();

    public static boolean addUser(String username, String password) throws SQLException {
        User user = new User(username, password, Permission.USER);
        return addUserByDetails(user);
    }

    public static List<User> getAllUsers() {
        return userList;
    }

    //If a account exists, return permission or null if a account already exists username or password.
    public static Permission getUser(String username, String password) throws SQLException {
        Permission userPermission = getUserByAccount(username,password);
        if(userPermission != null){
            return userPermission;
        } else {
            return null;
        }
    }

    public static void removeUser(User user) {
        userList.remove(user);
    }
}
