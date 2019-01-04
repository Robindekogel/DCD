package com.example.android.dcd_v31.StaffDetail;

public class emplyeeDetails {

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
    public String birthday;
    public String city;
    public String province;
    public String Efirstname;
    public String Einsertion;
    public String Elastname;
    public String Erelation;
    public String Ephonenumber;
    public String Eemail;


    public emplyeeDetails(String id, String firstname, String insertion, String lastname, String email, String phonenumber, String mobile, String mobileprivate, String street, String streetnumber, String zipcode,
                          String birthday, String city, String province, String Efirstname, String Einsertion, String Elastname, String Erelation, String Ephonenumber, String Eemail) {
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
        this.birthday = birthday;
        this.city = city;
        this.province = province;
        this.Efirstname = Efirstname;
        this.Einsertion = Einsertion;
        this.Elastname = Elastname;
        this.Erelation = Erelation;
        this.Ephonenumber = Ephonenumber;
        this.Eemail = Eemail;
    }

    public  String getId() { return  id;}

    public void setId(String id) { this.id = id; }

    public String getFirstname() {
        return firstname + " " + insertion + " " + lastname;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEfirstname() {
        return Efirstname + " " + Einsertion + " " + Elastname;
    }

    public void setEfirstname(String efirstname) {
        this.Efirstname = efirstname;
    }

    public String getEinsertion() {
        return Einsertion;
    }

    public void setEinsertion(String einsertion) {
        this.Einsertion = einsertion;
    }

    public String getElastname() {
        return Elastname;
    }

    public void setElastname(String elastname) {
        this.Elastname = elastname;
    }

    public String getErelation() {
        return Erelation;
    }

    public void setErelation(String erelation) {
        this.Erelation = erelation;
    }

    public String getEphonenumber() {
        return Ephonenumber;
    }

    public void setEphonenumber(String ephonenumber) {
        this.Ephonenumber = ephonenumber;
    }

    public String getEemail() {
        return Eemail;
    }

    public void setEemail(String eemail) {
        this.Eemail = eemail;
    }

    public emplyeeDetails(){

    }
}