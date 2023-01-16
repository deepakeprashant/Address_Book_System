package addressbook;

import java.util.*;

public class UserInterface {
    Scanner scan = new Scanner(System.in);
    String addressBookName;
    public String addAddressBook(){
        System.out.println("Enter Address Book Name");
        addressBookName = scan.next();
        return addressBookName;
    }

    public String checkAddressBook(HashMap<String , ArrayList<Contact>> map){
        System.out.println("Enter Address Book Name");
        addressBookName = scan.next();
        if (map.containsKey(addressBookName)) {
            return null;
        }
        return addressBookName;
    }
    public String choiceAddressBook(Map<String, ArrayList<Contact>> map) {
        Set<String> setKey = map.keySet();
        System.out.println(setKey);
        System.out.println("Enter Address Book name");
        String name = scan.next();
        return name;
    }
    public String searchContact() {
        System.out.println("ENTER PERSON NAME");
        return scan.next();
    }

    public int showAddressBook() {
        System.out.println("1] ADD NEW ADDRESS BOOK\n2] ADD CONTACT\n3] EDIT CONTACT\n4] DELETE CONTACT\n5] HISTORY\n6]EXIT");
        int choice = scan.nextInt();
        return choice;
    }
}
