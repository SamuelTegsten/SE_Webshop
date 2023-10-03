package com.web.se_webshop.BO.Model.ItemModel;

public class Item {
    private String picture;
    private String name;
    private String category;

    public Item(String picture, String name, String category) {
        this.picture = picture;
        this.name = name;
        this.category = category;
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

    @Override
    public String toString() {
        return "Item{" +
                "picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

