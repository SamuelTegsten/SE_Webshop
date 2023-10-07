package com.web.se_webshop.BO.Model.OrderLogic;

import com.web.se_webshop.DB.BDObjects.DbOrder;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static com.web.se_webshop.DB.BDObjects.DbItem.searchItemDB;
import static com.web.se_webshop.DB.BDObjects.DbOrder.packOrderDB;

/**
 * This class represents an order with properties such as username, item name, number of items, address, order status, date, and order ID.
 */
public class Order {
    private String username;
    private String itemName;
    private int numberOfItems;
    private String address;
    private OrderStatus status;
    private java.sql.Date date;
    private String orderId;

    /**
     * Protected constructor to create an Order object with specified properties.
     *
     * @param username      The username of the customer placing the order.
     * @param itemName      The name of the ordered item.
     * @param numberOfItems The number of items in the order.
     * @param address       The delivery address for the order.
     * @param status        The status of the order.
     * @param date          The date of the order.
     * @param orderId       The unique ID of the order.
     */
    protected Order(String username, String itemName, int numberOfItems, String address, OrderStatus status, java.sql.Date date, String orderId) {
        this.username = username;
        this.itemName = itemName;
        this.numberOfItems = numberOfItems;
        this.address = address;
        this.status = status;
        this.date = date;
        this.orderId = orderId;
    }

    /**
     * Protected constructor to create an Order object with specified properties and default order date.
     *
     * @param username      The username of the customer placing the order.
     * @param itemName      The name of the ordered item.
     * @param numberOfItems The number of items in the order.
     * @param address       The delivery address for the order.
     * @param status        The status of the order.
     */
    protected Order(String username, String itemName, int numberOfItems, String address, OrderStatus status) {
        this(username, itemName, numberOfItems, address, status, new java.sql.Date(System.currentTimeMillis()), null);
    }

    /**
     * Adds a list of orders to the database.
     *
     * @param orders The list of Order objects to be added.
     * @return True if the addition was successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public static boolean addOrder(ArrayList<Order> orders) throws SQLException {
        return DbOrder.addOrderDB(orders);
    }

    /**
     * Retrieves all orders from the database.
     *
     * @return A collection of all orders in the database.
     */
    static public Collection getAllOrders() {
        return DbOrder.getAllOrders();
    }

    /**
     * Packs an order by updating its status to "SENT" in the database.
     *
     * @param orderId The ID of the order to pack.
     * @throws SQLException if a database error occurs.
     */
    public static void packOrder(String orderId) throws SQLException {
        packOrderDB(orderId);
    }

    // Getter and Setter methods for Order properties

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

    public String getOrderId() {
        return orderId;
    }

    /**
     * Generates a string representation of the Order object.
     *
     * @return A string representation of the Order object.
     */
    @Override
    public String toString() {
        return "Order{" +
                "username='" + username + '\'' +
                ", itemName='" + itemName + '\'' +
                ", numberOfItems=" + numberOfItems +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", date=" + date +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
