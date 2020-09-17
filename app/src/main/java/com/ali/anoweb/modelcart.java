package com.ali.anoweb;

public class modelcart {
    String title,price,discounted,size,color,desc,quantity;
    int image,id,leftstock;

    public modelcart(String title, String price, String quantity, String discounted, String size, String color, String desc, int image, int id,int leftstock) {
        this.title = title;
        this.price = price;
        this.discounted = discounted;
        this.size = size;
        this.color = color;
        this.desc = desc;
        this.image = image;
        this.quantity = quantity;
        this.id = id;
        this.leftstock = leftstock;
    }

    public modelcart() {
    }

    public int getLeftstock() {
        return leftstock;
    }

    public void setLeftstock(int leftstock) {
        this.leftstock = leftstock;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscounted() {
        return discounted;
    }

    public void setDiscounted(String discounted) {
        this.discounted = discounted;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
