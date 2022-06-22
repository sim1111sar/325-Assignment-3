package com.example.myresturant;

import android.os.Parcel;
import android.os.Parcelable;

public class CartListContent {
    String Name,Quantity,Price;

    public CartListContent(String name, String quantity, String price) {
        Name = name;
        Quantity = quantity;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}