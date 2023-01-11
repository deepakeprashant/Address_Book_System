package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    public String firstName, lastName, address, city, state;
    public String zip, phoneNumber, emailId;
    public final int NAME = 1;
    public final int FULL_ADDRESS = 2;
    public final int NUMBER = 3;
    Scanner scan = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> getObject() {
        return contacts;
    }

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

    public void editContact(String userName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (userName.equals(contacts.get(i).firstName)) {
                editContactInformation(i);
                System.out.println("Successfully Edit Person Details !");
                break;
            }
        }
        System.out.println("Name Does Not Exist");
    }

    private void editContactInformation(int index) {
        System.out.println("\tWHICH DATA EDIT \n\t1] FULL NAME \n\t2] ADDRESS \n\t3] PHONE NUMBER");
        int choice = scan.nextInt();
        switch (choice) {
            case NAME:
                System.out.println("ENTER NEW FIRST NAME AND LAST NAME");
                contacts.get(index).firstName = scan.next();
                contacts.get(index).lastName = scan.next();
                break;
            case FULL_ADDRESS:
                System.out.println("ENTER NEW ADDRESS , CITY AND STATE");
                contacts.get(index).address = scan.next();
                contacts.get(index).city = scan.next();
                contacts.get(index).state = scan.next();
                break;
            case NUMBER:
                System.out.println(" ENTER NEW PHONE NUMBER");
                contacts.get(index).phoneNumber = scan.next();
                break;
            default:
                System.out.println("WRONG CHOICE ..THANK YOU");
        }
    }

    public void deleteInformation(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (name.equals(contacts.get(i).firstName)) {
                System.out.println("DELETED ALL INFORMATION " + contacts.get(i).firstName + " " + contacts.get(i).lastName);
                contacts.remove(i);
                break;
            }
        }
        System.out.println("Name Does Not Exist");
    }
}
