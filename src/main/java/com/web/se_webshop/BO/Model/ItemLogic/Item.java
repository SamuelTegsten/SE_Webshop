package com.web.se_webshop.BO.Model.ItemLogic;

import com.web.se_webshop.View.ObjectView.ItemView;

import java.sql.SQLException;

import static com.web.se_webshop.DB.BDObjects.DbItem.addItemDB;

public class Item {
    private String name;
    private String picture;
    private String category;
    private float price;

    protected Item(String name, String picture, String category, float price) {
        this.picture = picture;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    static public boolean addItem(ItemView itemView, int stockNumber) throws SQLException {
        return addItemDB(new Item(itemView.getName(), itemView.getPicture(), itemView.getCategory(), itemView.getPrice()), stockNumber);
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

