package com.web.se_webshop.BO.Model.ItemLogic;

import com.web.se_webshop.View.ObjectView.ItemView;

import java.sql.SQLException;

import static com.web.se_webshop.DB.BDObjects.DbItem.addItemDB;

public class Item {
    private String name;
    private String picture;
    private String category;
    private float price;

    private int stockNumber;

    protected Item(String name, String picture, String category, float price, int stockNumber) {
        this.picture = picture;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockNumber = stockNumber;
    }

    static public boolean addItem(ItemView itemView) throws SQLException {
        return addItemDB(new Item(itemView.getName(), itemView.getPicture(), itemView.getCategory(), itemView.getPrice(), itemView.getStockNumber()));
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

