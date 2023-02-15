package com.bridgelabz.addressbook.collection;

import java.util.*;
import java.util.stream.Collectors;

public class Repository {

    public final int NAME = 1;
    public final int FULL_ADDRESS = 2;
    public final int NUMBER = 3;
    Map<String, List<Contacts>> map = new HashMap<>();
    List<Contacts> contacts = new ArrayList<>();
    AddressBook addressBook = new AddressBook();
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
        Contacts editContactObject = findContactInObject();
        if (editContactObject != null) {
            editContactInformation(editContactObject);
            System.out.println("Successfully Edit Person Details !");

        }
        System.out.println("Name Does Not Exist");
    }

    public void deleteInformation() {
        Contacts removeContact = findContactInObject();
        if (removeContact != null) {
            contacts.remove(removeContact);
            System.out.println("Contact Deleted");
        }
        System.out.println("Name Does Not Exist");
    }

    private Contacts findContactInObject() {
        String bookName = addressBook.choiceAddressBook(map);
        Contacts removeObject = null;
        if (bookName != null) {
            System.out.println("Enter Person First Name");
            String name = scan.next();
            removeObject = map.get(bookName).stream()
                    .filter(n -> n.firstName.equals(name))
                    .findFirst()
                    .orElse(null);
            return removeObject;
        }
        System.out.println(bookName + "Book Not Available");
        return removeObject;
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

        List<Map.Entry<String,List<Contacts>>> countCity;
        countCity = map.entrySet()
                .stream()
                .filter(n->n.getValue().get(0).getCity().equals(location)
                        || n.getValue().get(0).getState().equals(location))
                .collect(Collectors.toList());
        System.out.println("Total Same City Or State Belong Person :- "+countCity);
    }

    private void editContactInformation(Contacts editContactObject) {
        System.out.println("\tWHICH DATA EDIT \n\t1] FULL NAME \n\t2] ADDRESS " +
                "\n\t3] PHONE NUMBER");
        int choice = scan.nextInt();
        switch (choice) {
            case NAME:
                System.out.println("ENTER NEW FIRST NAME AND LAST NAME");
                editContactObject.setFirstName(scan.next());
                editContactObject.setLastName(scan.next());
                break;
            case FULL_ADDRESS:
                System.out.println("ENTER NEW ADDRESS , CITY AND STATE");
                editContactObject.setAddress(scan.next());
                editContactObject.setCity(scan.next());
                editContactObject.setState(scan.next());
                break;
            case NUMBER:
                System.out.println(" ENTER NEW PHONE NUMBER");
                editContactObject.setPhoneNumber(scan.next());
                break;
            default:
                System.out.println("WRONG CHOICE ..THANK YOU");
        }
    }
}
