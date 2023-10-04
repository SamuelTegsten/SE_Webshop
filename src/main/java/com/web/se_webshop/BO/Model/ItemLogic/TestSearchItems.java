package com.web.se_webshop.BO.Model.ItemLogic;

import com.web.se_webshop.DB.BDObjects.DbItem;
import com.web.se_webshop.DB.DBManager.DBConnect;

public class TestSearchItems {
    public static void main(String[] args) {
        DBConnect.getConnection();
        System.out.println(DbItem.searchItemDB("Casco"));
    }
}
