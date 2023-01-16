package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    public String firstName, lastName, address, city, state;
    public String zip, phoneNumber, emailId;

    Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String emailId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    @Override
    public String toString() {
        return "" +
                "\nFullName = " + firstName +
                " " + lastName +
                ",\t Address - " + address +
                " " + city +
                "\tState = " + state +
                "-" + zip +
                "\tMobile No.:: " + phoneNumber +
                "\n";
    }
}
