package com.example.android.dcd_v31.Customers;

public class Customers {

    public String id;
    public String firstname;
    public String insertion;
    public String lastname;
    public String email;
    public String phonenumber;
    public String mobile;
    public String mobileprivate;
    public String street;
    public String streetnumber;
    public String zipcode;

    public Customers(String id, String firstname, String insertion, String lastname, String email, String phonenumber, String mobile, String mobileprivate, String street, String streetnumber, String zipcode) {
        this.id = id;
        this.firstname = firstname;
        this.insertion = insertion;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.mobile = mobile;
        this.mobileprivate = mobileprivate;
        this.street = street;
        this.streetnumber = streetnumber;
        this.zipcode = zipcode;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getInsertion() {
        return insertion;
    }

    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customers() {
    }
}
