package com.example.foodfake.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    private String name;
    private float price;
    private int totalInCart;
    private String url;

    public Menu() {
    }

    public Menu(String name, float price, String url) {
        this.name = name;
        this.price = price;
        this.url = url;
    }

    public Menu(String name, float price, int totalInCart, String url) {
        this.name = name;
        this.price = price;
        this.totalInCart = totalInCart;
        this.url = url;
    }

    public int getTotalInCart() {
        return totalInCart;
    }

    public void setTotalInCart(int totalInCart) {
        this.totalInCart = totalInCart;
    }

    protected Menu(Parcel in) {
        name = in.readString();
        price = in.readFloat();
        url = in.readString();
        totalInCart = in.readInt();
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeFloat(price);
        dest.writeString(url);
        dest.writeInt(totalInCart);
    }
}