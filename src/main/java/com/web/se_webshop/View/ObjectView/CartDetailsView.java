package com.web.se_webshop.View.ObjectView;

public class CartDetailsView {
    private String itemName;
    private int numberOfItems;

    public CartDetailsView(String itemName, int numberOfItems) {
        this.itemName = itemName;
        this.numberOfItems = numberOfItems;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}
