package addressbook;

import java.util.Scanner;

public class AddressBook {
    public String firstName, lastName, address, city, state;
    public String zip, phoneNumber, emailId;
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("WELCOME TO ADDRESS BOOK");
        AddressBook addressBook = new AddressBook();
        addressBook.addPersonInfo();
        addressBook.printAddressBook();
    }

    void addPersonInfo() {
        System.out.println("ENTER PERSON FIRST NAME AND LAST NAME");
        firstName = scan.next();
        lastName = scan.next();
        System.out.println("ENTER ADDRESS AND CITY NAME");
        address = scan.next();
        city = scan.next();
        System.out.println("ENTER STATE AND ZIP");
        state = scan.next();
        zip = scan.next();
        System.out.println("ENTER PERSON PHONE NUMBER");
        phoneNumber = scan.next();
        System.out.println("ENTER PERSON EMAIL ID");
        emailId = scan.next();
    }

    void printAddressBook() {
        System.out.println("\n::--------- ADDRESS BOOK -----------::");
        System.out.println(":: PERSON NAME  :- "+firstName+" "+lastName);
        System.out.println(":: PERSON ADDRESS :- "+address+" "+city);
        System.out.println("::\t\t\t\t\t"+state+" Pin:-"+zip);
        System.out.println(":: MOBILE NUMBER :- "+phoneNumber);
        System.out.println(":: EMAIL ID :- "+emailId);
        System.out.println("::-------------------------------------::");
    }
}
