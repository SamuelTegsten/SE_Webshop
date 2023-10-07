package com.web.se_webshop.View.ObjectView;

import java.util.ArrayList;

/**
 * Represents details of items in a shopping cart.
 */
public class CartDetails {
    private ItemView item;
    private int numberOfItems;

    /**
     * Constructs a CartDetails object with the given item and quantity.
     *
     * @param item          The ItemView representing the item in the cart.
     * @param numberOfItems The quantity of the item in the cart.
     */
    public CartDetails(ItemView item, int numberOfItems) {
        this.item = item;
        this.numberOfItems = numberOfItems;
    }

    /**
     * Gets the item in the cart.
     *
     * @return The ItemView representing the item in the cart.
     */
    public ItemView getItem() {
        return item;
    }

    /**
     * Sets the item in the cart.
     *
     * @param item The ItemView representing the item in the cart.
     */
    public void setItem(ItemView item) {
        this.item = item;
    }

    /**
     * Gets the quantity of the item in the cart.
     *
     * @return The quantity of the item in the cart.
     */
    public int getNumberOfItems() {
        return numberOfItems;
    }

    /**
     * Sets the quantity of the item in the cart.
     *
     * @param numberOfItems The quantity of the item in the cart.
     */
    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    /**
     * Calculates and returns the total amount for all items in the cart.
     *
     * @param cart The list of CartDetails representing items in the cart.
     * @return The total amount for all items in the cart.
     */
    public static float getTotalAmount(ArrayList<CartDetails> cart) {
        float total = 0;
        for (CartDetails c : cart) {
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
