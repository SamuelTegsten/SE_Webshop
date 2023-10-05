package com.web.se_webshop.View.ObjectView;

import com.web.se_webshop.BO.Model.OrderLogic.OrderStatus;

import java.sql.Date;

public class OrderView {
    private String username;
    private String itemName;
    private int numberOfItems;
    private String address;
    private OrderStatus status;
    private java.sql.Date date;
    private String orderId;

    public OrderView(String username, String itemName, int numberOfItems, String address, OrderStatus status, Date date, String orderId) {
        this.username = username;
        this.itemName = itemName;
        this.numberOfItems = numberOfItems;
        this.address = address;
        this.status = status;
        this.date = date;
        this.orderId = orderId;
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

    public Date getDate() {
        return date;
    }

    public String getOrderId() {
        return orderId;
    }
}
