package com.web.se_webshop.DB.BDObjects;

import com.web.se_webshop.BO.Model.ItemLogic.Item;
import com.web.se_webshop.BO.Model.OrderLogic.Order;
import com.web.se_webshop.BO.Model.OrderLogic.OrderStatus;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbOrder extends Order{
    protected DbOrder(String username, String itemName, int numberOfItems, String address, OrderStatus orderStatus, java.sql.Date date) {
        super(username, itemName, numberOfItems, address, orderStatus);
    }
    public static boolean addOrderDB(ArrayList<Order> orders) throws SQLException {
        System.out.println("hola 1");
        System.out.println(orders);
        System.out.println("hola2");

        String sql = "INSERT INTO `order` (username, item_name, number_of_items, address, status, order_date) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
                pstmt = DBConnect.getConnection().prepareStatement(sql);
                DBConnect.getConnection().setAutoCommit(false);
            for(int i=0; i<orders.size(); i++) {

                pstmt.setString(1, orders.get(i).getUsername());
                pstmt.setString(2, orders.get(i).getItemName());
                pstmt.setInt(3, orders.get(i).getNumberOfItems());
                pstmt.setString(4, orders.get(i).getAddress());
                pstmt.setString(5, orders.get(i).getStatus().toString());
                pstmt.setDate(6, orders.get(i).getDate());
                pstmt.executeUpdate();
            }


            DBConnect.getConnection().commit();
            return true;

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
