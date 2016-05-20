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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
       this.phone = phone;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    String name;
    int phone;
    Address address;
    String email;



    String id;
    public Customer()   {
        name = new String();
        email = new String();
        phone = 0;
        address = new Address();
        id = new String();
    }
}
