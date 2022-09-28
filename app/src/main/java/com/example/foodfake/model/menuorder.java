package com.example.foodfake.model;

public class menuorder {
    private String name;
    private float price;
    private int totalInCart;
    private String url;


    public menuorder() {
    }

    public menuorder(String name, float price, int totalInCart, String url) {
        this.name = name;
        this.price = price;
        this.totalInCart = totalInCart;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTotalInCart() {
        return totalInCart;
    }

    public void setTotalInCart(int totalInCart) {
        this.totalInCart = totalInCart;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
