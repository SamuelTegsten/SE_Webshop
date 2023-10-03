package com.web.se_webshop.BO.Handler.OrderHandler;

import com.web.se_webshop.BO.Model.OrderModel.Order;
import com.web.se_webshop.BO.Model.OrderModel.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class orderHandler {
    private static List<Order> orderList = new ArrayList<>();

    public static void addOrder(Order order) {
        order.setDate();
        orderList.add(order);
    }
    public static List<Order> getAllOrders() {
        return orderList;
    }
    public static Order getOrder(String username, String itemName) {
        for (Order order : orderList) {
            if (order.getUsername().equals(username) && order.getItemName().equals(itemName)) {
                return order;
            }
        }
        return null;
    }

    public static void updateOrderStatus(Order order, OrderStatus newStatus) {
        order.setStatus(newStatus);
    }

    public static void removeOrder(Order order) {
        orderList.remove(order);
    }
}

