package com.masterandroid.ehome;

public class Regservice {

    //Declare the variables
    private String firstname;
    private String lastname;
    private String email;
    private String serviceoffering;
    private String certnumber;
    private String identity;
    private String mobile;
    private String location;

    //Create a default constructor
    public Regservice() {
    }

    //Overload the constructor with required parameters for adding the user to the Firebase firestore
    public Regservice(String firstname, String lastname, String email, String serviceoffering, String certnumber, String identity, String mobile, String location) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.serviceoffering = serviceoffering;
        this.certnumber = certnumber;
        this.identity = identity;
        this.mobile = mobile;
        this.location = location;
    }

    public String getFirstname() {
        return firstname;
    }

    //Provide the getters to access the values to other classes
    public String getLastname() {
        return lastname;
    }
    public String getEmail() {
        return email;
    }
    public String getServiceoffering() {
        return serviceoffering;
    }
    public String getCertnumber() {
        return certnumber;
    }

    public String getIdentity() {
        return identity;
    }
    public String getMobile() {
        return mobile;
    }
    public String getLocation() {
        return location;
    }

}
