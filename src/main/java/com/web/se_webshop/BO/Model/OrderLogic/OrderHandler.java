package com.web.se_webshop.BO.Model.OrderLogic;

import com.web.se_webshop.BO.Model.ItemLogic.Item;
import com.web.se_webshop.View.Controller.OrderServlet;
import com.web.se_webshop.View.ObjectView.CartDetails;
import com.web.se_webshop.View.ObjectView.ItemView;
import com.web.se_webshop.View.ObjectView.OrderView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * This class handles operations related to orders, including adding, packing, retrieving, updating, and removing orders.
 */
public class OrderHandler extends OrderServlet {
    private static ArrayList<Order> orderList = new ArrayList<>();

    /**
     * Adds an order to the order list based on cart details and user information, then adds the order to the database.
     *
     * @param userName The username of the customer placing the order.
     * @param cart     The list of cart details containing items and quantities.
     * @param address  The delivery address for the order.
     * @return True if the addition was successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public static boolean addOrder(String userName, ArrayList<CartDetails> cart, String address) throws SQLException {
        boolean success = false;
        for (CartDetails cartDetails : cart) {
            orderList.add(new Order(userName, cartDetails.getItem().getName(), cartDetails.getNumberOfItems(), address, OrderStatus.IN_PROGRESS));
        }
        success = Order.addOrder(orderList);
        orderList.clear();
        return success;
    }

    /**
     * Packs an order by updating its status to "SENT" in the database.
     *
     * @param orderId The ID of the order to pack.
     * @throws SQLException if a database error occurs.
     */
    public static void packOrder(String orderId) throws SQLException {
        Order.packOrder(orderId);
    }

    /**
     * Retrieves all orders from the database and converts them into OrderView objects.
     *
     * @return A list of OrderView objects representing all orders in the database.
     */
    public static ArrayList<OrderView> getAllOrders() {
        ArrayList<OrderView> tempOrderView = new ArrayList<>();
        Collection tempDbOrder = Order.getAllOrders();
        for (Iterator it = tempDbOrder.iterator(); it.hasNext(); ) {
            Order order = (Order) it.next();
            tempOrderView.add(new OrderView(order.getUsername(), order.getItemName(), order.getNumberOfItems(), order.getAddress(), order.getStatus(), order.getDate(), order.getOrderId()));
        }
        return tempOrderView;
    }

    /**
     * Retrieves an order based on the username and item name.
     *
     * @param username The username of the customer who placed the order.
     * @param itemName The name of the ordered item.
     * @return The Order object if found, or null if not found.
     */
    public static Order getOrder(String username, String itemName) {
        for (Order order : orderList) {
            if (order.getUsername().equals(username) && order.getItemName().equals(itemName)) {
                return order;
            }
        }
        return null;
    }

    /**
     * Updates the status of an order.
     *
     * @param order     The order to update.
     * @param newStatus The new status for the order.
     */
    public static void updateOrderStatus(Order order, OrderStatus newStatus) {
        order.setStatus(newStatus);
    }

    /**
     * Removes an order from the order list.
     *
     * @param order The order to remove.
     */
    public static void removeOrder(Order order) {
        orderList.remove(order);
    }
}
