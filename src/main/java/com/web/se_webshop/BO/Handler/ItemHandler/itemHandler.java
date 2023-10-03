package com.web.se_webshop.BO.Handler.ItemHandler;

import com.web.se_webshop.BO.Model.ItemModel.Item;

import java.util.ArrayList;
import java.util.List;

public class itemHandler {
    private static List<Item> itemList = new ArrayList<>();
    public static void addItem(Item item) {
        itemList.add(item);
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

