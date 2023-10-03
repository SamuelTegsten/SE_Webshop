package com.web.se_webshop.BO.Model.ItemLogic;

import com.web.se_webshop.DB.BDObjects.DbItem;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.SQLException;

public class TestAddItem {

    public static void main(String[] args) throws SQLException {
        DBConnect.getConnection();
        DbItem.addItem(new Item("Style/Pictures/knife1.png", "Army Knife","Knives" ,149.99F), 3);
    }
}
