package com.ali.anoweb;

public class modelproducts {
    String title, description, price,discount,daysleft,leftinstock,size,color;
    int image;

    public modelproducts(String title, String price, int image, String discount) {
        this.title = title;
        this.price = price;
        this.image = image;
        this.discount = discount;
    }

    public modelproducts() {
    }

    public String getDaysleft() {
        return daysleft;
    }

    public void setDaysleft(String daysleft) {
        this.daysleft = daysleft;
    }

    public String getLeftinstock() {
        return leftinstock;
    }

    public void setLeftinstock(String leftinstock) {
        this.leftinstock = leftinstock;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
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
