package com.web.se_webshop.DB.BDObjects;

import com.web.se_webshop.BO.Model.ItemLogic.Item;
import com.web.se_webshop.BO.Model.OrderLogic.Order;
import com.web.se_webshop.BO.Model.OrderLogic.OrderStatus;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DbOrder extends Order{

    private static Connection connection = DBConnect.getConnection();
    protected DbOrder(String username, String itemName, int numberOfItems, String address, OrderStatus orderStatus, java.sql.Date date, String orderId){
        super(username, itemName, numberOfItems, address, orderStatus, date, orderId);
    }
    protected DbOrder(String username, String itemName, int numberOfItems, String address, OrderStatus orderStatus) {
        super(username, itemName, numberOfItems, address, orderStatus);
    }

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



    public static Collection getAllOrders() {
        ArrayList<DbOrder> orders = new ArrayList<>();
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

            for(int i=0; i<orders.size(); i++) {
                // update new order to sql
                pstmt1.setString(1, orders.get(i).getUsername());
                pstmt1.setString(2, orders.get(i).getItemName());
                pstmt1.setInt(3, orders.get(i).getNumberOfItems());
                pstmt1.setString(4, orders.get(i).getAddress());
                pstmt1.setString(5, orders.get(i).getStatus().toString());
                pstmt1.setDate(6, orders.get(i).getDate());
                pstmt1.executeUpdate();
                // get the amount of items in stock
                sql = "SELECT stockNumber FROM item WHERE name = ?";
                pstmt2 = connection.prepareStatement(sql);
                pstmt2.setString(1, orders.get(i).getItemName());
                ResultSet pResultSet = pstmt2.executeQuery();
                if(pResultSet.next()) {
                    stockNumber = pResultSet.getInt("stockNumber");
                }
                    newStock = stockNumber - orders.get(i).getNumberOfItems();
                // update stock in database
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
