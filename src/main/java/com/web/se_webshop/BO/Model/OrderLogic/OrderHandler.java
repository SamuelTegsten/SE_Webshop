package com.web.se_webshop.BO.Model.OrderLogic;

import java.util.ArrayList;
import java.util.List;

public class OrderHandler {
    private static List<Order> orderList = new ArrayList<>();

    public static void addOrder(Order order) {
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

