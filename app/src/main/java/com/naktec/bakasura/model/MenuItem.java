package com.naktec.bakasura.model;

/**
 * Created by dganeshappa on 5/18/2016.
 */
public class MenuItem {
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    int price;
    String name;
    String id;
    boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public MenuItem()
    {
        name = new String();
        id = new String();
        available = true;

    }
}
