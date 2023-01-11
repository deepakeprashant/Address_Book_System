package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    public String firstName, lastName, address, city, state;
    public String zip, phoneNumber, emailId;
    Scanner scan = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();
    void addPersonInfo() {
        Contact object = new Contact();
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
        contacts.add(object);
    }

    void printAddressBook() {
        System.out.println("\n::--------- ADDRESS BOOK -----------::");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("PERSON NAME = " + contacts.get(i).firstName + " " + contacts.get(i).lastName);
            System.out.println("PERSON ADDRESS = " + contacts.get(i).address + " " + contacts.get(i).city + " " + contacts.get(i).state + " " + contacts.get(i).zip);
            System.out.println("PERSON PHONE NUMBER = " + contacts.get(i).phoneNumber + "\nEMAIL ID = " + contacts.get(i).emailId);
            System.out.println("\n!--------------------------------------------------------------------!");
        }
    }

    public int addressBook() {
        System.out.println("1] ADD CONTACT\n2] HISTORY\n3]EXIT");
        int choice = scan.nextInt();
        return choice;
    }
}
