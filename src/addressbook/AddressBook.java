package addressbook;

import java.util.Scanner;

public class AddressBook {
    public static final int ADD_CONTACT = 1;
    public static final int DISPLAY = 2;
    public static final int EXIT =3;
    public static void main(String[] args) {
        System.out.println("WELCOME TO ADDRESS BOOK");
        Contact contact = new Contact();
        while (true){
            switch (contact.addressBook()){
                case ADD_CONTACT :
                    contact.addPersonInfo();
                    break;
                case DISPLAY:
                    contact.printAddressBook();
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
