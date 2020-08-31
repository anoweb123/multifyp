package com.ali.anoweb;

public class modelslider
{
    String name;
    int img;

    public modelslider(int img,String name) {
        this.name = name;
        this.img = img;
    }

    public modelslider() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
