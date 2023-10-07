package com.web.se_webshop.DB.BDObjects;

import com.web.se_webshop.BO.Model.ItemLogic.Item;
import com.web.se_webshop.BO.Model.OrderLogic.Order;
import com.web.se_webshop.BO.Model.OrderLogic.OrderStatus;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents a database operation for orders.
 */
public class DbOrder extends Order {

    // The database connection
    private static Connection connection = DBConnect.getConnection();

    /**
     * Protected constructor to initialize a DbOrder object.
     *
     * @param username     The username associated with the order.
     * @param itemName     The name of the item in the order.
     * @param numberOfItems The number of items in the order.
     * @param address      The shipping address for the order.
     * @param orderStatus  The status of the order.
     * @param date         The date of the order.
     * @param orderId      The unique order ID.
     */
    protected DbOrder(String username, String itemName, int numberOfItems, String address, OrderStatus orderStatus, java.sql.Date date, String orderId) {
        super(username, itemName, numberOfItems, address, orderStatus, date, orderId);
    }

    /**
     * Updates the status of an order in the database to 'SENT'.
     *
     * @param orderId The ID of the order to be updated.
     * @throws SQLException if a database error occurs.
     */
    public static void packOrderDB(String orderId) throws SQLException {

        String sql = "UPDATE `order` SET status = 'SENT' WHERE order_id = ?";
        PreparedStatement pstmt = null;
        try {
            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, orderId);

            pstmt.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException(e);
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    /**
     * Retrieves all orders from the database.
     *
     * @return A collection of DbOrder objects representing all orders in the database.
     */
    public static Collection getAllOrders() {
        ArrayList<DbOrder> orders = new ArrayList<>();
        Connection con = connection;
        String sql = "SELECT * FROM `order`";
        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            ResultSet pResultSet = pstm.executeQuery();
            while (pResultSet.next()) {
                orders.add(new DbOrder(
                        pResultSet.getString("username"),
                        pResultSet.getString("item_name"),
                        pResultSet.getInt("number_of_items"),
                        pResultSet.getString("address"),
                        OrderStatus.valueOf(pResultSet.getString("status")),
                        pResultSet.getDate("order_date"),
                        pResultSet.getString("order_id")
                ));
            }
            return (ArrayList<DbOrder>) orders.clone();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Adds a list of orders to the database and updates item stock.
     *
     * @param orders The list of orders to be added.
     * @return True if the operation was successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public static boolean addOrderDB(ArrayList<Order> orders) throws SQLException {

        String sql = "INSERT INTO `order` (username, item_name, number_of_items, address, status, order_date) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        int stockNumber = 0;
        int newStock;
        try {
            pstmt1 = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            for (int i = 0; i < orders.size(); i++) {
                // Update new order to SQL
                pstmt1.setString(1, orders.get(i).getUsername());
                pstmt1.setString(2, orders.get(i).getItemName());
                pstmt1.setInt(3, orders.get(i).getNumberOfItems());
                pstmt1.setString(4, orders.get(i).getAddress());
                pstmt1.setString(5, orders.get(i).getStatus().toString());
                pstmt1.setDate(6, orders.get(i).getDate());
                pstmt1.executeUpdate();
                // Get the amount of items in stock
                sql = "SELECT stockNumber FROM item WHERE name = ?";
                pstmt2 = connection.prepareStatement(sql);
                pstmt2.setString(1, orders.get(i).getItemName());
                ResultSet pResultSet = pstmt2.executeQuery();
                if (pResultSet.next()) {
                    stockNumber = pResultSet.getInt("stockNumber");
                }
                newStock = stockNumber - orders.get(i).getNumberOfItems();
                // Update stock in the database
                sql = "UPDATE item SET stockNumber = ? WHERE name = ?";
                pstmt3 = connection.prepareStatement(sql);
                pstmt3.setInt(1, newStock);
                pstmt3.setString(2, orders.get(i).getItemName());
                pstmt3.executeUpdate();
            }

            connection.commit();
            return true;

        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException(e);
        } finally {
            if (pstmt1 != null) pstmt1.close();
            if (pstmt2 != null) pstmt2.close();
            if (pstmt3 != null) pstmt3.close();
            connection.setAutoCommit(true);
        }
    }
}
