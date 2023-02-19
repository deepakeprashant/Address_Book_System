package com.bridgelabz.addressbook.collection;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressBook {
    String addressBookName;
    Scanner scan = new Scanner(System.in);

    int showChoiceBoard() {
        System.out.println("Enter 1] New Address Book\nEnter 2] New Add Contact Person\n" +
                "Enter 3] Edit Contact \nEnter 4] Delete Contact\n" +
                "Enter 5] Search Belong City / State\nEnter 6] Sorting \n"+
                "Enter 7] Display AddressBookEnter\nEnter 8] Exit Address Book");
        return scan.nextInt();
    }

    String getAddressBookName() {
        System.out.println("Enter Address Book Name");
        addressBookName = scan.next();
        return addressBookName;
    }

    public String choiceAddressBook(Map<String, List<Contacts>> map) {
        Set<String> setKey = map.keySet();
        System.out.println("Address Book Names :- " + setKey);
        System.out.println("Choice Address Book");
        addressBookName = scan.next();
        if (map.containsKey(addressBookName)) {
            return addressBookName;
        }
        return null;
    }

    public String checkDuplicateAddressBook(String bookName,Map<String, List<Contacts>> map){
        if (map.containsKey(bookName)){
            System.out.println("Sorry , Address Book Name Already Present");
            return null;
        }
        return bookName;
    }

    public void showAddressBook(Map<String, List<Contacts>> map) {
        System.out.println("Address Book Display");
        for (Map.Entry<String, List<Contacts>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public String getLocation() {
        System.out.println("Enter city or state name");
        String location = scan.next();
        return location;
    }
}
