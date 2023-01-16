package addressbook;

import java.util.*;

public class Repository {
    public final int NAME = 1;
    public final int FULL_ADDRESS = 2;
    public final int NUMBER = 3;
    Scanner scan = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();
    HashMap<String, ArrayList<Contact>> map = new HashMap<>();
    public HashMap<String , ArrayList<Contact>> getAddressBookObj() {
        return map;
    }
    public void addContactList(String addressBookName ,Contact contactObj) {
        if (map.containsKey(addressBookName)){
            contacts.add(contactObj);
            map.put(addressBookName , contacts);
        }else {
            ArrayList<Contact> newContact = new ArrayList<>();
            newContact.add(contactObj);
            map.put(addressBookName , newContact);
        }
    }

    public void handleDisplay() {
        Set<String> setKey = map.keySet();
        System.out.println(setKey + " [ALL]");
        System.out.println("Choice Address Book");
        String name = scan.next();
        if (name.equals("ALL")) {
            for (Map.Entry<String, ArrayList<Contact>> entry : map.entrySet()) {
                System.out.println("Address Book = " + entry.getKey() + "" + entry.getValue());
            }
            return;
        }
        System.out.println(map.get(name));
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
