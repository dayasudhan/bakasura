package com.naktec.bakasura.model;

import java.util.ArrayList;

/**
 * Created by dganeshappa on 5/19/2016.
 */
public class Order {
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<MenuOrder> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuOrder> menuItems) {
        this.menuItems = menuItems;
    }

    public HotelItem getHotelItem() {
        return hotelItem;
    }

    public void setHotelItem(HotelItem hotelItem) {
        this.hotelItem = hotelItem;
    }

    Customer customer;
    HotelItem hotelItem;
    ArrayList<MenuOrder> menuItems;
    public Order()
    {
        customer = new Customer();
        hotelItem = new HotelItem();
        menuItems = new ArrayList<MenuOrder>();
    }

}
