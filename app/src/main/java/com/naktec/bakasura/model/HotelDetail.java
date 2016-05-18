package com.naktec.bakasura.model;

import java.util.ArrayList;

/**
 * Created by dganeshappa on 5/18/2016.
 */
public class HotelDetail {


    Integer phone;
    int deliveryRange;
    String id;
    ArrayList<String> deliveryAreas;
    Address address;
    ArrayList<MenuItem> menuItem;
    HotelItem hotelItem;
    String speciality;


    public HotelDetail()
    {
        hotelItem = new HotelItem();

        id = new String();
        address = new Address();
        menuItem = new ArrayList<MenuItem>();
        speciality = new String();
        deliveryAreas = new ArrayList<String>();
        deliveryRange = 3;
        phone = new Integer(0);
    }


    public ArrayList<MenuItem> getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(ArrayList<MenuItem> menuItem) {
        this.menuItem = menuItem;
    }
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public ArrayList<String> getDeliveryAreas() {
        return deliveryAreas;
    }

    public void setDeliveryAreas(ArrayList<String> deliveryAreas) {
        this.deliveryAreas = deliveryAreas;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public HotelItem getHotelItem() {
        return hotelItem;
    }

    public void setHotelItem(HotelItem hotelItem) {
        this.hotelItem = hotelItem;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getDeliveryRange() {
        return deliveryRange;
    }

    public void setDeliveryRange(int deliveryRange) {
        this.deliveryRange = deliveryRange;
    }

}
