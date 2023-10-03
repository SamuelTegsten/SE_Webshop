package com.web.se_webshop.BO.Model.ItemModel;

import com.web.se_webshop.DB.DBItem.DbItem;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.SQLException;

public class TestAddItem {

    public static void main(String[] args) throws SQLException {
        DBConnect.getConnection();
        DbItem.addItem(new Item("pic", "Kniv","Kill" ,20.00F), 5);
    }


}
