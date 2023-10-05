package com.web.se_webshop.BO.Model.OrderLogic;

import com.web.se_webshop.View.ObjectView.CartDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderHandler {
    private static ArrayList<Order> orderList = new ArrayList<>();

    public static boolean addOrder(String userName, ArrayList<CartDetails> cart, String address) throws SQLException {
        boolean success = false;
        for(CartDetails cartDetails : cart){
            orderList.add( new Order(userName, cartDetails.getItem().getName(), cartDetails.getNumberOfItems(), address, OrderStatus.IN_PROGRESS));
        }
        success = Order.addOrder(orderList);
        orderList.clear();
        return success;
    }
    public static ArrayList<Order> getAllOrders() {
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

