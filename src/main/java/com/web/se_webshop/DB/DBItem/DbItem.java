package com.web.se_webshop.DB.DBItem;

import com.web.se_webshop.BO.Model.ItemModel.Item;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbItem extends Item {
    private DbItem(String name, String picture, String category, float price) {
        super(picture, name, category, price);
    }

    public static void addItem(Item item, int stockNumber) throws SQLException {

        String sql = "INSERT INTO Item VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = DBConnect.getConnection().prepareStatement(sql);
            DBConnect.getConnection().setAutoCommit(false);
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getPicture());
            pstmt.setString(3, item.getCategory());
            pstmt.setFloat(4, item.getPrice());
            pstmt.setInt(5, stockNumber);

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
