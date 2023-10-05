package com.web.se_webshop.BO.Model.OrderLogic;

import com.web.se_webshop.DB.BDObjects.DbOrder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Order {
    private String username;
    private String itemName;
    private int numberOfItems;
    private String address;
    private OrderStatus status;
    private java.sql.Date date;

    protected Order(String username, String itemName, int numberOfItems, String address, OrderStatus status) {
        this.username = username;
        this.itemName = itemName;
        this.numberOfItems = numberOfItems;
        this.address = address;
        this.status = status;
        this.date = new java.sql.Date(System.currentTimeMillis());
    }

    public static boolean addOrder(ArrayList<Order> orders) throws SQLException {
        return DbOrder.addOrderDB(orders);
    }

    public String getUsername() {
        return username;
    }
    public String getItemName() {
        return itemName;
    }
    public int getNumberOfItems() {
        return numberOfItems;
    }
    public String getAddress() {
        return address;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public java.sql.Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "username='" + username + '\'' +
                ", itemName='" + itemName + '\'' +
                ", numberOfItems=" + numberOfItems +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", date=" + date +
                '}';
    }
}

