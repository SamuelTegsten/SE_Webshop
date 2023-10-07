package com.web.se_webshop.BO.Model.ItemLogic;

import com.web.se_webshop.DB.BDObjects.DbItem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents an item with its properties such as name, picture, category, price, and stock number.
 */
public class Item {
    private String name;
    private String picture;
    private String category;
    private float price;
    private int stockNumber;

    /**
     * Protected constructor to create an Item object with specified properties.
     *
     * @param name        The name of the item.
     * @param picture     The picture URL of the item.
     * @param category    The category of the item.
     * @param price       The price of the item.
     * @param stockNumber The stock number of the item.
     */
    protected Item(String name, String picture, String category, float price, int stockNumber) {
        this.picture = picture;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockNumber = stockNumber;
    }

    /**
     * Adds an item to the database.
     *
     * @param item The Item object to be added.
     * @return True if the addition was successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    static public boolean addItem(Item item) throws SQLException {
        return DbItem.addItemDB(item);
    }

    /**
     * Removes an item from the database.
     *
     * @param itemName The name of the item to remove.
     * @return True if the removal was successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public static boolean removeItem(String itemName) throws SQLException {
        return DbItem.removeItem(itemName);
    }

    /**
     * Searches for items in the database based on a search text.
     *
     * @param searchText The text to search for in item names.
     * @return A collection of items that match the search criteria.
     */
    static public Collection searchItem(String searchText) {
        return DbItem.searchItemDB(searchText);
    }

    /**
     * Updates the picture URL of an item in the database.
     *
     * @param itemName   The name of the item to update.
     * @param newPicture The new picture URL for the item.
     * @return True if the update was successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public static boolean updatePicture(String itemName, String newPicture) throws SQLException {
        return DbItem.updatePictureDb(itemName, newPicture);
    }

    /**
     * Updates the category of an item in the database.
     *
     * @param itemName    The name of the item to update.
     * @param newCategory The new category for the item.
     * @return True if the update was successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public static boolean updateCategory(String itemName, String newCategory) throws SQLException {
        return DbItem.updateCategoryDb(itemName, newCategory);
    }

    /**
     * Retrieves all items from the database.
     *
     * @return A collection of all items in the database.
     */
    static public Collection getAllItem() {
        return DbItem.getAllItemDB();
    }

    /**
     * Getter for the item's picture URL.
     *
     * @return The picture URL of the item.
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Setter for the item's picture URL.
     *
     * @param picture The new picture URL for the item.
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * Getter for the item's name.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the item's name.
     *
     * @param name The new name for the item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the item's category.
     *
     * @return The category of the item.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter for the item's category.
     *
     * @param category The new category for the item.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter for the item's price.
     *
     * @return The price of the item.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Setter for the item's price.
     *
     * @param price The new price for the item.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Getter for the item's stock number.
     *
     * @return The stock number of the item.
     */
    public int getStockNumber() {
        return stockNumber;
    }

    /**
     * Generates a string representation of the Item object.
     *
     * @return A string representation of the Item object.
     */
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", stockNumber='" + stockNumber + '\'' +
                '}';
    }
}
