package com.example.android.dcd_v31.Staff;

public class StaffMember {
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

    public StaffMember(String id, String firstname, String insertion, String lastname, String email, String phonenumber, String mobile, String mobileprivate, String street, String streetnumber, String zipcode) {
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

    public  String getId() { return  id;}

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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMobile() {
        return phonenumber;
    }

    public void setMobile(String mobile) {
        this.mobile= mobile;
    }

    public String getMobileprivate() {
        return mobileprivate;
    }

    public void setMobileprivate(String mobileprivate) {
        this.mobileprivate = mobileprivate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) { this.street = street; }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) { this.streetnumber = streetnumber; }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public StaffMember(){

    }
}

