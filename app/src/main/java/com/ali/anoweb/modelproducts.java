package com.ali.anoweb;

public class modelproducts {
    String title, description, price;
    int image;

    public modelproducts(String title, String price, int image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public modelproducts() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
