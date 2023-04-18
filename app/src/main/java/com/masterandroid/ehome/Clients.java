package com.masterandroid.ehome;

import android.widget.ListView;

/*
* Class to model client information
* */
public class Clients {

    //Declare the views
    private String service;
    private String location;
    private String street;
    private String mobile;
    private String identity;
    private String payment_mode;

    //Default constructor
    public Clients() {

    }

    //Overload the constructor with the required values.
    public Clients(String service, String location, String street, String mobile, String identity, String payment_mode ) {
        this.service = service;
        this.location = location;
        this.street = street;
        this.mobile = mobile;
        this.identity = identity;
        this.payment_mode = payment_mode;
    }

    //Getters to expose the values to other classes
    public String getService() {
        return service;
    }
    public void setService(String service) {
        this.service = service;
    }
    public String getLocation() {
        return location;
    }
    public String getStreet() {
        return street;
    }
    public String getMobile() {
        return mobile;
    }
    public String getIdentity() {
        return identity;
    }
    public String getPayment_mode() {
        return payment_mode;
    }
}