package com.naktec.bakasura.model;

/**
 * Created by dganeshappa on 11/10/2015.
 */
public class Customer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    String name;
    String phone;
    Address address;
    String email;

    public Customer()   {
        name = new String();
        email = new String();
        phone = new String();
        address = new Address();
    }
}
