package com.bridgelabz.addressbooks;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonInfo {
    public String firstName, lastName, address, city, state;
    public String zip, phoneNumber, emailId;
    public static final int name = 1;
    public static final int fullAddress = 2;
    public static final int number = 3;
    ArrayList<PersonInfo> person = new ArrayList<PersonInfo>();

    Scanner scan = new Scanner(System.in);

    public void addPerson() {
        PersonInfo object = new PersonInfo();
        System.out.println("ENTER PERSON FIRST NAME AND LAST NAME");
        object.firstName = scan.next();
        object.lastName = scan.next();
        System.out.println("ENTER ADDRESS AND CITY NAME");
        object.address = scan.next();
        object.city = scan.next();
        System.out.println("ENTER STATE AND ZIP");
        object.state = scan.next();
        object.zip = scan.next();
        System.out.println("ENTER PERSON PHONE NUMBER");
        object.phoneNumber = scan.next();
        System.out.println("ENTER PERSON EMAIL ID");
        object.emailId = scan.next();
        person.add(object);
    }

    public void deleteInformation(String name) {
        for (int i = 0; i < person.size(); i++) {
            if (name.equals(person.get(i).firstName)) {
                System.out.println("DELETED ALL INFORMATION " + person.get(i).firstName + " " + person.get(i).lastName);
                person.remove(i);
                break;
            }
        }
        System.out.println("Name Does Not Exist");
    }

    public void editInformation(String name) {
        for (int i = 0; i < person.size(); i++) {
            if (name.equals(person.get(i).firstName)) {
                editContact(i);
                System.out.println("Successfully Edit Person Details !");
                break;
            }
        }
        System.out.println("Name Does Not Exist");
    }

    public void display() {
        for (int i = 0; i < person.size(); i++) {
            System.out.println("PERSON NAME = " + person.get(i).firstName + " " + person.get(i).lastName);
            System.out.println("PERSON ADDRESS = " + person.get(i).address + " " + person.get(i).city + " " + person.get(i).state + " " + person.get(i).zip);
            System.out.println("PERSON PHONE NUMBER = " + person.get(i).phoneNumber + "\nEMAIL ID = " + person.get(i).emailId);
            System.out.println("\n!--------------------------------------------------------------------!");
        }
    }

    public void editContact(int index) {
        System.out.println("\tWHICH DATA EDIT \n\t1] FULL NAME \n\t2] ADDRESS \n\t3] PHONE NUMBER");
        int choice = scan.nextInt();
        switch (choice) {
            case name:
                System.out.println("ENTER NEW FIRST NAME AND LAST NAME");
                person.get(index).firstName = scan.next();
                person.get(index).lastName = scan.next();
                break;
            case fullAddress:
                System.out.println("ENTER NEW ADDRESS , CITY AND STATE");
                person.get(index).address = scan.next();
                person.get(index).city = scan.next();
                person.get(index).state = scan.next();
                break;
            case number:
                System.out.println(" ENTER NEW PHONE NUMBER");
                person.get(index).phoneNumber = scan.next();
                break;
            default:
                System.out.println("WRONG CHOICE ..THANK YOU");
        }
    }
}
