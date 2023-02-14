package com.bridgelabz.addressbooks;

import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        System.out.println(":: WELCOME TO ADDRESS BOOK PROGRAM ::");
        PersonInfo personObject = new PersonInfo();
        String name;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("1] ADD PERSON INFORMATION");
            System.out.println("2] EDIT PERSON INFORMATION");
            System.out.println("3] DELETE PERSON INFORMATION");
            System.out.println("4] HISTORY");
            System.out.println("5] Exit");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    personObject.addPerson();
                    break;
                case 2:
                    System.out.println("ENTER PERSON NAME");
                    name = scan.next();
                    personObject.editInformation(name);
                    break;
                case 3:
                    System.out.println("ENTER PERSON NAME");
                    name = scan.next();
                    personObject.deleteInformation(name);
                    break;
                case 4:
                    personObject.display();
                    break;
                case 5:
                    System.out.println("Thank You..!");
                    System.exit(0);
                default:
                    System.out.println("WRONG CHOICE");
            }
        }
    }
}
