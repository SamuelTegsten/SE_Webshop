package com.web.se_webshop.BO.Handler.ItemHandler;

import com.web.se_webshop.BO.Model.ItemModel.Item;
import com.web.se_webshop.View.ItemView.ItemView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class itemHandler {
    private static List<Item> itemList = new ArrayList<>();
    public static void addItem(ItemView itemView, int stockNumber) throws SQLException {
        Item.addItem(itemView, stockNumber);
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

