package com.web.se_webshop.BO.Model.OrderLogic;

import com.web.se_webshop.BO.Model.ItemLogic.Item;
import com.web.se_webshop.DB.BDObjects.DbItem;
import com.web.se_webshop.DB.BDObjects.DbOrder;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.SQLException;
import java.util.Date;

public class TestAddOrder {
    public static void main(String[] args) throws SQLException {
        DBConnect.getConnection();
        Date currentDate = new Date();
        //DbOrder.addOrderDB(new Order("esteban", "knife", 3, "söder 123", OrderStatus.SENT));
    }
}
