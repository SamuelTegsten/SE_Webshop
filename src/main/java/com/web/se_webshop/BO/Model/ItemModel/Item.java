package com.web.se_webshop.BO.Model.ItemModel;

import com.web.se_webshop.View.ItemView.ItemView;

import java.sql.SQLException;

import static com.web.se_webshop.DB.DBItem.DbItem.addItemDB;

public class Item {
    private String name;
    private String picture;
    private String category;
    private float price;

    protected Item(String name, String picture, String category, float price) {
        this.name = name;
        this.picture = picture;
        this.category = category;
        this.price = price;
    }

    static public void addItem(ItemView itemView, int stockNumber) throws SQLException {
        addItemDB(new Item(itemView.getName(), itemView.getPicture(), itemView.getCategory(), itemView.getPrice()), stockNumber);
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

