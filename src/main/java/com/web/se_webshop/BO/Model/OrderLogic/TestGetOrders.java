package com.web.se_webshop.BO.Model.OrderLogic;

import com.web.se_webshop.DB.BDObjects.DbOrder;

import java.util.ArrayList;

public class TestGetOrders {

    public static void main(String[] args) {
        ArrayList<Order> orders = (ArrayList<Order>) DbOrder.getAllOrders();
        System.out.println(orders);
    }
}
