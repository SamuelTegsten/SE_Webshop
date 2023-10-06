package com.web.se_webshop.BO.Model.OrderLogic;

import com.web.se_webshop.BO.Model.ItemLogic.Item;
import com.web.se_webshop.BO.Model.OrderLogic.Order;
import com.web.se_webshop.BO.Model.OrderLogic.OrderStatus;
import com.web.se_webshop.DB.BDObjects.DbItem;
import com.web.se_webshop.DB.BDObjects.DbOrder;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TestAddOrder {
    public static void main(String[] args) throws SQLException {
        ArrayList<Order> orders= new ArrayList();
        orders.add(new Order("esteban", "Jacket", 3, "söder 123", OrderStatus.SENT));
        DBConnect.getConnection();
        Date currentDate = new Date();
        DbOrder.addOrderDB(orders);
    }
}
