package com.web.se_webshop.View.ObjectView;

import com.web.se_webshop.BO.Model.OrderLogic.OrderStatus;

import java.sql.Date;

/**
 * Represents an order's view with information such as username, item name, number of items, address, order status, date, and order ID.
 */
public class OrderView {
    private String username;
    private String itemName;
    private int numberOfItems;
    private String address;
    private OrderStatus status;
    private Date date;
    private String orderId;

    /**
     * Constructs an OrderView object with the given order details.
     *
     * @param username     The username associated with the order.
     * @param itemName     The name of the item in the order.
     * @param numberOfItems The number of items in the order.
     * @param address      The delivery address for the order.
     * @param status       The status of the order (IN_PROGRESS, SENT, or COMPLETED).
     * @param date         The date when the order was placed.
     * @param orderId      The unique identifier for the order.
     */
    public OrderView(String username, String itemName, int numberOfItems, String address, OrderStatus status, Date date, String orderId) {
        this.username = username;
        this.itemName = itemName;
        this.numberOfItems = numberOfItems;
        this.address = address;
        this.status = status;
        this.date = date;
        this.orderId = orderId;
    }

    /**
     * Gets the username associated with the order.
     *
     * @return The username associated with the order.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the name of the item in the order.
     *
     * @return The name of the item in the order.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Gets the number of items in the order.
     *
     * @return The number of items in the order.
     */
    public int getNumberOfItems() {
        return numberOfItems;
    }

    /**
     * Gets the delivery address for the order.
     *
     * @return The delivery address for the order.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the status of the order (IN_PROGRESS, SENT, or COMPLETED).
     *
     * @return The status of the order.
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * Gets the date when the order was placed.
     *
     * @return The date when the order was placed.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the unique identifier for the order.
     *
     * @return The unique identifier for the order.
     */
    public String getOrderId() {
        return orderId;
    }
}
