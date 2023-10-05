package com.web.se_webshop.View.ObjectView;

import java.util.ArrayList;

public class CartDetails {
    private ItemView item;
    private int numberOfItems;

    public CartDetails(ItemView item, int numberOfItems) {
        this.item = item;
        this.numberOfItems = numberOfItems;
    }

    public ItemView getItem() {
        return item;
    }

    public void setItem(ItemView item) {
        this.item = item;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public static float getTotalAmount (ArrayList<CartDetails> cart){
        float total =0;
        for(CartDetails c : cart){
            total += (c.getItem().getPrice() * c.numberOfItems);
        }
        return total;
    }

}
