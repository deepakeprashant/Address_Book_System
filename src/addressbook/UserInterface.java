package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner scan = new Scanner(System.in);

    public String searchContact() {
        System.out.println("ENTER PERSON NAME");
        return scan.next();
    }

    public int addressBook() {
        System.out.println("1] ADD CONTACT \n2] EDIT CONTACT\n3] HISTORY\n4]EXIT");
        int choice = scan.nextInt();
        return choice;
    }
    void printAddressBook(ArrayList<Contact> contacts) {
        System.out.println("\n::--------- ADDRESS BOOK -----------::");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("PERSON NAME = " + contacts.get(i).firstName + " " + contacts.get(i).lastName);
            System.out.println("PERSON ADDRESS = " + contacts.get(i).address + " " + contacts.get(i).city + " " + contacts.get(i).state + " " + contacts.get(i).zip);
            System.out.println("PERSON PHONE NUMBER = " + contacts.get(i).phoneNumber + "\nEMAIL ID = " + contacts.get(i).emailId);
            System.out.println("\n!--------------------------------------------------------------------!");
        }
    }
}
