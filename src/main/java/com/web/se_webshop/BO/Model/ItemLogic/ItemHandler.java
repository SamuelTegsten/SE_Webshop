package com.web.se_webshop.BO.Model.ItemLogic;

import com.web.se_webshop.View.ObjectView.ItemView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static com.web.se_webshop.BO.Model.ItemLogic.Item.getAllItem;
import static com.web.se_webshop.DB.BDObjects.DbItem.searchItemDB;

public class ItemHandler {
    private static List<Item> itemList = new ArrayList<>();
    public static boolean addItem(ItemView itemView) throws SQLException {
        return Item.addItem(new Item(itemView.getName(), itemView.getPicture(), itemView.getCategory(), itemView.getPrice(), itemView.getStockNumber()));
    }

    public static ArrayList<ItemView> searchItem(String searchText){
        ArrayList<ItemView> tempItemView = new ArrayList<>();
        Collection tempDbItem = Item.searchItem(searchText);
        for(Iterator it = tempDbItem.iterator(); it.hasNext();){
            Item item = (Item)it.next();
            tempItemView.add(new ItemView(item.getName(), item.getPicture(), item.getCategory(), item.getPrice(), item.getStockNumber()));
        }
        return tempItemView;
    }
    public static ArrayList<ItemView> getAllItems() {
        ArrayList<ItemView> tempItemView = new ArrayList<>();
        Collection tempDbItem = getAllItem();
        for(Iterator it = tempDbItem.iterator(); it.hasNext();){
            Item item = (Item)it.next();
            tempItemView.add(new ItemView(item.getName(), item.getPicture(), item.getCategory(), item.getPrice(), item.getStockNumber()));
        }
        return tempItemView;
    }
    public static Item getItemByName(String itemName) {
        for (Item item : itemList) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
    public static boolean removeItem(String itemName) throws SQLException {
        return Item.removeItem(itemName);
    }

    public static boolean updatePicture(String itemName, String newPicture) throws SQLException {
        return Item.updatePicture(itemName, newPicture);
    }

    public static boolean updateCategory(String itemName, String newCategory) throws SQLException {
        return Item.updateCategory(itemName, newCategory);

    }
}

