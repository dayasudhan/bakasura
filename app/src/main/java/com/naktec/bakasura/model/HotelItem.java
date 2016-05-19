package com.naktec.bakasura.model;

/**
 * Created by dganeshappa on 5/18/2016.
 */
public class HotelItem {
    public HotelItem()
    {
        name = new String();
        email = new String();
        phone = new Integer(0);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    String name;
    String email;
    Integer phone;
}
