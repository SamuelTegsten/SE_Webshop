package com.web.se_webshop.DB.BDObjects;

import com.web.se_webshop.BO.Model.ItemLogic.Item;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class extends the Item class and provides functionality for executing CRUD operations on the database
 */
public class DbItem extends Item {

    /**
     * Constructor to create a DbItem object.
     * @param name     The name of the item.
     * @param picture  The picture URL of the item.
     * @param category The category of the item.
     * @param price    The price of the item.
     */
    private DbItem(String name, String picture, String category, float price, int stockNumber) {
        super(picture, name, category, price, stockNumber);
    }


    public static ArrayList<DbItem> searchItems(String searchedName){
        ArrayList<DbItem> foundItems = new ArrayList<>();
        Connection con = DBConnect.getConnection();
        String sql = "SELECT * FROM item WHERE name LIKE ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, "%" + searchedName + "%");
            ResultSet pResultSet = pstm.executeQuery();
            while (pResultSet.next()) {
                Item tempItem;
                foundItems.add(new DbItem(
                        pResultSet.getString("name"),
                        pResultSet.getString("picture"),
                        pResultSet.getString("category"),
                        pResultSet.getFloat("price"),
                        pResultSet.getInt("stockNumber")
                ));

            }
            return (ArrayList<DbItem>) foundItems.clone();
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }



    }








    /**
     * Adds an item to the database with a specified stock number.
     * @param item        The Item object to be added to the database.
     * @param stockNumber The stock number of the item.
     * @throws SQLException If a database error occurs during the operation.
     */

    public static boolean addItemDB(Item item) throws SQLException {
        // SQL statement for inserting a new item with stock number.
        String sql = "INSERT INTO Item VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            // Prepare the SQL statement and disable auto-commit to start a transaction.
            DBConnect.getConnection();
            pstmt = DBConnect.getConnection().prepareStatement(sql);
            DBConnect.getConnection().setAutoCommit(false);
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getPicture());
            pstmt.setString(3, item.getCategory());
            pstmt.setFloat(4, item.getPrice());
            pstmt.setInt(5, item.getStockNumber());

            // Execute the SQL statement to insert the item.
            pstmt.executeUpdate();

            // Commit the transaction to save changes to the database.
            DBConnect.getConnection().commit();
            return true;
        } catch (SQLException e) {
            // Rollback the transaction and throw an exception if a database error occurs.
            DBConnect.getConnection().rollback();
            throw new SQLException(e);
        } finally {
            // Close the prepared statement to release resources.
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }


}
