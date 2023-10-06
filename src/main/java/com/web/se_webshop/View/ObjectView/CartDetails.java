package com.web.se_webshop.View.ObjectView;

import java.util.ArrayList;

public class CartDetails {
    private ItemView item;
    private int numberOfItems;
    private static int cartDetailID=0;

    public CartDetails(ItemView item, int numberOfItems) {
        this.item = item;
        this.numberOfItems = numberOfItems;
        this.cartDetailID = cartDetailID+1;
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

    @Override
    public String toString() {
        return "CartDetails{" +
                "item=" + item +
                ", numberOfItems=" + numberOfItems +
                '}';
    }
}
