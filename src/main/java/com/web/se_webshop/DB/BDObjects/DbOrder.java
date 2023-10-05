package com.web.se_webshop.DB.BDObjects;

import com.web.se_webshop.BO.Model.ItemLogic.Item;
import com.web.se_webshop.BO.Model.OrderLogic.Order;
import com.web.se_webshop.BO.Model.OrderLogic.OrderStatus;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DbOrder extends Order{
    protected DbOrder(String username, String itemName, int numberOfItems, String address, OrderStatus orderStatus, java.sql.Date date, String orderId){
        super(username, itemName, numberOfItems, address, orderStatus, date, orderId);
    }
    protected DbOrder(String username, String itemName, int numberOfItems, String address, OrderStatus orderStatus) {
        super(username, itemName, numberOfItems, address, orderStatus);
    }




    public static Collection getAllOrders() {
        ArrayList<DbOrder> orders = new ArrayList<>();
        Connection con = DBConnect.getConnection();
        String sql = "SELECT * FROM `order`";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
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
