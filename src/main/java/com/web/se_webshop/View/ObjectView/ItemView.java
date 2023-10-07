package com.web.se_webshop.View.ObjectView;

/**
 * Represents an item's view with information such as name, picture, category, price, and stock number.
 */
public class ItemView {

    private String name;
    private String picture;
    private String category;
    private float price;
    private int stockNumber;

    /**
     * Constructs an ItemView object with the given item details.
     *
     * @param name        The name of the item.
     * @param picture     The URL of the item's picture.
     * @param category    The category of the item.
     * @param price       The price of the item.
     * @param stockNumber The stock number of the item.
     */
    public ItemView(String name, String picture, String category, float price, int stockNumber) {
        this.name = name;
        this.picture = picture;
        this.category = category;
        this.price = price;
        this.stockNumber = stockNumber;
    }

    /**
     * Gets the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the URL of the item's picture.
     *
     * @return The URL of the item's picture.
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Gets the category of the item.
     *
     * @return The category of the item.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the price of the item.
     *
     * @return The price of the item.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Gets the stock number of the item.
     *
     * @return The stock number of the item.
     */
    public int getStockNumber() {
        return stockNumber;
    }

    @Override
    public String toString() {
        return "ItemView{" +
                "name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stockNumber=" + stockNumber +
                '}';
    }
}
