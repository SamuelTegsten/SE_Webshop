package com.web.se_webshop.BO.Model.ItemLogic;

import com.web.se_webshop.View.ObjectView.ItemView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static com.web.se_webshop.BO.Model.ItemLogic.Item.getAllItem;
import static com.web.se_webshop.DB.BDObjects.DbItem.searchItemDB;

/**
 * This class handles operations related to items, including adding, searching, retrieving, removing, and updating items.
 */
public class ItemHandler {

    /**
     * Adds an item to the database using information from an ItemView object.
     *
     * @param itemView The ItemView object containing item information.
     * @return True if the addition was successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public static boolean addItem(ItemView itemView) throws SQLException {
        return Item.addItem(new Item(itemView.getName(), itemView.getPicture(), itemView.getCategory(), itemView.getPrice(), itemView.getStockNumber()));
    }

    /**
     * Searches for items in the database based on a search text.
     *
     * @param searchText The text to search for in item names.
     * @return A list of ItemView objects that match the search criteria.
     */
    public static ArrayList<ItemView> searchItem(String searchText) {
        ArrayList<ItemView> tempItemView = new ArrayList<>();
        Collection tempDbItem = Item.searchItem(searchText);
        for (Iterator it = tempDbItem.iterator(); it.hasNext(); ) {
            Item item = (Item) it.next();
            tempItemView.add(new ItemView(item.getName(), item.getPicture(), item.getCategory(), item.getPrice(), item.getStockNumber()));
        }
        return tempItemView;
    }

    /**
     * Retrieves all items from the database.
     *
     * @return A list of ItemView objects representing all items in the database.
     */
    public static ArrayList<ItemView> getAllItems() {
        ArrayList<ItemView> tempItemView = new ArrayList<>();
        Collection tempDbItem = getAllItem();
        for (Iterator it = tempDbItem.iterator(); it.hasNext(); ) {
            Item item = (Item) it.next();
            tempItemView.add(new ItemView(item.getName(), item.getPicture(), item.getCategory(), item.getPrice(), item.getStockNumber()));
        }
        return tempItemView;
    }

    /**
     * Removes an item from the database.
     *
     * @param itemName The name of the item to remove.
     * @return True if the removal was successful, false otherwise.
     * @throws SQLException if a database error occurs.
     */
    public static boolean removeItem(String itemName) throws SQLException {
        return Item.removeItem(itemName);
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
        return Item.updatePicture(itemName, newPicture);
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
        return Item.updateCategory(itemName, newCategory);
    }
}
