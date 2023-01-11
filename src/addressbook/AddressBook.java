package addressbook;

import java.util.ArrayList;

public class AddressBook {
    public static final int ADD_CONTACT = 1;
    public static final int EDIT_CONTACT = 2;
    public static final int DISPLAY = 3;
    public static final int EXIT =4;
    public static void main(String[] args) {
        System.out.println("WELCOME TO ADDRESS BOOK");
        Contact contact = new Contact();
        UserInterface userInterface = new UserInterface();
        while (true){
            switch (userInterface.addressBook()){
                case ADD_CONTACT :
                    contact.addPersonInfo();
                    break;
                case EDIT_CONTACT:
                    contact.editContact(userInterface.searchContact());
                    break;
                case DISPLAY:
                    ArrayList<Contact> contactObject = contact.getObject();
                    userInterface.printAddressBook(contactObject);
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
