package com.web.se_webshop.DB.BDObjects;

import com.web.se_webshop.BO.Model.ItemLogic.Item;
import com.web.se_webshop.BO.Model.OrderLogic.Order;
import com.web.se_webshop.BO.Model.OrderLogic.OrderStatus;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbOrder extends Order{
    protected DbOrder(String username, String itemName, int numberOfItems, String address, OrderStatus orderStatus, Date date) {
        super(username, itemName, numberOfItems, address, orderStatus);
    }
    public static void addOrder(Order order) throws SQLException {

        String sql = "INSERT INTO `order` (username, item_name, number_of_items, address, status, order_date) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = DBConnect.getConnection().prepareStatement(sql);
            DBConnect.getConnection().setAutoCommit(false);
            pstmt.setString(1, order.getUsername());
            pstmt.setString(2, order.getItemName());
            pstmt.setInt(3, order.getNumberOfItems());
            pstmt.setString(4, order.getAddress());
            pstmt.setString(5, order.getStatus().toString());
            pstmt.setDate(6, order.getDate());

            pstmt.executeUpdate();

            DBConnect.getConnection().commit();

        } catch (SQLException e) {

            DBConnect.getConnection().rollback();
            throw new SQLException(e);
        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
        }
    }
}
