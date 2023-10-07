package com.web.se_webshop.DB.BDObjects;

import com.web.se_webshop.BO.Model.ItemLogic.Item;
import com.web.se_webshop.DB.DBManager.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class extends the Item class and provides functionality for executing CRUD operations on the database.
 */
public class DbItem extends Item {

    /**
     * Private constructor to create a DbItem object.
     *
     * @param name        The name of the item.
     * @param picture     The picture URL of the item.
     * @param category    The category of the item.
     * @param price       The price of the item.
     * @param stockNumber The stock number of the item.
     */
    private DbItem(String name, String picture, String category, float price, int stockNumber) {
        super(name, picture, category, price, stockNumber);
    }

    // The database connection
    private static Connection connection = DBConnect.getConnection();

    /**
     * Updates the picture URL of an item in the database.
     *
     * @param itemName   The name of the item to update.
     * @param newPicture The new picture URL for the item.
     * @return True if the update was successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public static boolean updatePictureDb(String itemName, String newPicture) throws SQLException {
        String sql = "UPDATE item SET picture = ? WHERE name = ?";
        connection.setAutoCommit(false);
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newPicture);
            pstmt.setString(2, itemName);
            pstmt.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException(e);
        }
    }

    /**
     * Updates the category of an item in the database.
     *
     * @param itemName    The name of the item to update.
     * @param newCategory The new category for the item.
     * @return True if the update was successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public static boolean updateCategoryDb(String itemName, String newCategory) throws SQLException {
        String sql = "UPDATE item SET category = ? WHERE name = ?";
        connection.setAutoCommit(false);
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newCategory);
            pstmt.setString(2, itemName);
            pstmt.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException(e);
        }
    }

    /**
     * Search for items in the database based on a search text.
     *
     * @param searchText The text to search for in item names.
     * @return A collection of DbItem objects that match the search criteria.
     */
    public static Collection searchItemDB(String searchText) {
        ArrayList<DbItem> foundItems = new ArrayList<>();
        Connection con = connection;
        String sql = "SELECT * FROM item WHERE name LIKE ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, "%" + searchText + "%");
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
     * Remove an item from the database.
     *
     * @param itemName The name of the item to remove.
     * @return True if the removal was successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public static boolean removeItem(String itemName) throws SQLException {
        String sql = "DELETE FROM item WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            pstmt.setString(1, itemName);
            pstmt.executeUpdate();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException(e);
        }
    }

    /**
     * Adds an item to the database with a specified stock number.
     *
     * @param item The Item object to be added to the database.
     * @return True if the addition was successful, false otherwise.
     * @throws SQLException If a database error occurs during the operation.
     */
    public static boolean addItemDB(Item item) throws SQLException {
        // SQL statement for inserting a new item with stock number.
        String sql = "INSERT INTO Item VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            // Prepare the SQL statement and disable auto-commit to start a transaction.
            pstmt = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getPicture());
            pstmt.setString(3, item.getCategory());
            pstmt.setFloat(4, item.getPrice());
            pstmt.setInt(5, item.getStockNumber());

            // Execute the SQL statement to insert the item.
            pstmt.executeUpdate();

            // Commit the transaction to save changes to the database.
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            // Rollback the transaction and throw an exception if a database error occurs.
            connection.rollback();
            throw new SQLException(e);
        } finally {
            // Close the prepared statement to release resources.
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    /**
     * Retrieves all items from the database.
     *
     * @return A collection of all items in the database.
     */
    public static Collection<Item> getAllItemDB() {
        ArrayList<Item> allItems = new ArrayList<>();
        Connection con = connection;
        String sql = "SELECT * FROM item";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            ResultSet pResultSet = pstm.executeQuery();
            while (pResultSet.next()) {
                allItems.add(new DbItem(
                        pResultSet.getString("name"),
                        pResultSet.getString("picture"),
                        pResultSet.getString("category"),
                        pResultSet.getFloat("price"),
                        pResultSet.getInt("stockNumber")
                ));
            }
            return allItems;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
