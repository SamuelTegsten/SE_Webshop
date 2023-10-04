package com.web.se_webshop.View.ObjectView;

public class ItemView {

    private String name;
    private String picture;
    private String category;
    private float price;

    private int stockNumber;

    public ItemView(String name, String picture, String category, float price, int stockNumber) {
        this.name = name;
        this.picture = picture;
        this.category = category;
        this.price = price;
        this.stockNumber = stockNumber;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public int getStockNumber() {
        return stockNumber;
    }
}