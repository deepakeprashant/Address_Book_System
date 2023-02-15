package com.bridgelabz.addressbook.collection;

import java.util.*;

public class Repository {

    public final int NAME = 1;
    public final int FULL_ADDRESS = 2;
    public final int NUMBER = 3;
    Map<String, List<Contacts>> map = new HashMap<>();
    List<Contacts> contacts = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    public Map<String, List<Contacts>> getReturnAddressBook() {
        return map;
    }

    void addAddressBook(String addressBookName, Contacts newPerson) {
        if (map.containsKey(addressBookName)) {
            contacts = map.get(addressBookName);
            long duplicate = contacts.stream()
                    .map(contacts1 -> contacts1.getFirstName())
                    .filter(n -> n.equals(newPerson.firstName))
                    .count();
            if (duplicate == 0) {
                contacts.add(newPerson);
                map.put(addressBookName, contacts);
            } else {
                System.out.println("Person name already exits");
            }
        } else {
            List<Contacts> newContact = new ArrayList<>();
            newContact.add(newPerson);
            map.put(addressBookName, newContact);
        }
    }

    public void editContact() {
        System.out.println("Enter Person First Name");
        String userName = scan.next();
        for (int i = 0; i < contacts.size(); i++) {
            if (userName.equals(contacts.get(i).firstName)) {
                editContactInformation(i);
                System.out.println("Successfully Edit Person Details !");
                break;
            }
        }
        System.out.println("Name Does Not Exist");
    }

    public void deleteInformation() {
        System.out.println("Enter Person First Name");
        String name = scan.next();
        for (int i = 0; i < contacts.size(); i++) {
            if (name.equals(contacts.get(i).firstName)) {
                System.out.println("DELETED ALL INFORMATION "
                        + contacts.get(i).firstName + " "
                        + contacts.get(i).lastName);
                contacts.remove(i);
                break;
            }
        }
        System.out.println("Name Does Not Exist");
    }

    public void searchPersonBelongCityOrState(String location) {
        System.out.println(":: Person Name\tMobile Number\tSame City Or State ::");
        map.entrySet()
                .forEach(contact -> contact.getValue()
                        .stream()
                        .filter(n -> n.city.contains(location)
                                || n.state.contains(location))
                        .forEach(n -> System.out.println(" " + n.getFirstName()
                                + " " + n.getLastName()
                                + "\t " + n.getPhoneNumber()
                                + "\t" + n.getCity() + " " + n.getState()
                                + "\n")));
    }

    private void editContactInformation(int index) {
        System.out.println("\tWHICH DATA EDIT \n\t1] FULL NAME \n\t2] ADDRESS " +
                "\n\t3] PHONE NUMBER");
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
}
