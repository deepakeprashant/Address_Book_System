package addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    public static final int NEW_ADDRESSBOOK = 1;
    public static final int ADD_CONTACT = 2;
    public static final int EDIT_CONTACT = 3;
    public static final int DELETE_CONTACT = 4;
    public static final int DISPLAY = 5;
    public static final int EXIT = 6;

    public static Repository repository = new Repository();
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("WELCOME TO ADDRESS BOOK");
        AddressBook addressBook = new AddressBook();
        UserInterface userInterface = new UserInterface();
        String bookName;
        HashMap<String , ArrayList<Contact>> map= repository.getAddressBookObj();
        while (true) {
          if (map.isEmpty()){
              System.out.println("Address Book Empty");
              addressBook.getContactList(userInterface.addAddressBook());
          }else {
              switch (userInterface.showAddressBook()) {
                  case NEW_ADDRESSBOOK:
                      bookName = userInterface.checkAddressBook(map);
                      if (bookName == null){
                          System.out.println("Address Book Already Exits");
                          return;
                      }
                      addressBook.getContactList(bookName);
                      break;
                  case ADD_CONTACT:
                      bookName = userInterface.choiceAddressBook(map);
                      addressBook.getContactList(bookName);
                      break;
                  case EDIT_CONTACT:
                      repository.editContact(userInterface.searchContact());
                      break;
                  case DELETE_CONTACT:
                      repository.deleteInformation(userInterface.searchContact());
                      break;
                  case DISPLAY:
                      repository.handleDisplay();
                      break;
                  case EXIT:
                      System.out.println("THANK YOU");
                      System.exit(0);
                  default:
                      System.out.println("WRONG CHOICE! PLEASE ENTER AGAIN");
              }
          }
        }
    }
    public void getContactList(String bookName){
        System.out.println("ENTER PERSON FIRST NAME AND LAST NAME");
        String firstName = scan.next();
        String lastName = scan.next();
        System.out.println("ENTER ADDRESS AND CITY NAME");
        String address = scan.next();
        String city = scan.next();
        System.out.println("ENTER STATE AND ZIP");
        String state = scan.next();
        String zip = scan.next();
        System.out.println("ENTER PERSON PHONE NUMBER");
        String phoneNumber = scan.next();
        System.out.println("ENTER PERSON EMAIL ID");
        String emailId = scan.next();
        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, emailId);
        repository.addContactList(bookName , contact);
    }
}