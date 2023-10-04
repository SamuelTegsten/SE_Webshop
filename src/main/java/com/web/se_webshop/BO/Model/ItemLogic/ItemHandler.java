package com.web.se_webshop.BO.Model.ItemLogic;

import com.web.se_webshop.View.ObjectView.ItemView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemHandler {
    private static List<Item> itemList = new ArrayList<>();
    public static boolean addItem(ItemView itemView) throws SQLException {
        return Item.addItem(itemView);
    }
    public static List<Item> getAllItems() {
        return itemList;
    }
    public static Item getItemByName(String itemName) {
        for (Item item : itemList) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
    public static void removeItem(Item item) {
        itemList.remove(item);
    }
}

