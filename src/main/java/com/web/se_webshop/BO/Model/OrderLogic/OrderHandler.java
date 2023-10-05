package com.web.se_webshop.BO.Model.OrderLogic;

import com.web.se_webshop.BO.Model.ItemLogic.Item;
import com.web.se_webshop.View.ObjectView.CartDetails;
import com.web.se_webshop.View.ObjectView.ItemView;
import com.web.se_webshop.View.ObjectView.OrderView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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

    public static ArrayList<OrderView> getAllOrders(){
        ArrayList<OrderView> tempOrderView = new ArrayList<>();
        Collection tempDbOrder = Order.getAllOrders();
        for(Iterator it = tempDbOrder.iterator(); it.hasNext();){
            Order order = (Order)it.next();
            tempOrderView.add(new OrderView(order.getUsername(), order.getItemName(), order.getNumberOfItems(), order.getAddress(), order.getStatus(), order.getDate(), order.getOrderId()));
        }
        return tempOrderView;
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

