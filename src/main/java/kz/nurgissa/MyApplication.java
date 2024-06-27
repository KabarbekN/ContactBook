package kz.nurgissa;

import kz.nurgissa.controller.ContactController;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;


@RequiredArgsConstructor
public class MyApplication {
    private final ContactController contactController;
    private Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.println("""
                1 -> Работа с контактом
                2 -> Работа с компанией
                """);

        switch (scanner.nextInt()){
            case 1:
                contactController();
                break;
            case 2:
                contactController();
                break;
            default:
                System.out.println("No such choice, please try again");
                start();
        }
    }

    protected void contactController(){
                System.out.println("""
                1 -> Show all contacts
                2 -> Add new contact
                3 -> Show contact by id
                4 -> Delete contact by id
                5 -> Update contact by id
                """);

                switch (scanner.nextInt()){
                    case 1:
                        showAllContacts();
                    case 2:
                        addNewContact();
                }

    }

    public void showAllContacts(){
        contactController.getAllContacts().forEach(System.out::println);
      restart();
    }

    public void restart(){
        System.out.println("Do you want to continue? (y/n)");
        switch (scanner.next()){
            case "y", "Y":
                start();
                break;
            case "n", "N":
                System.out.println("Goodbye");
                break;
        }
    }

    public void addNewContact(){
        System.out.println("Creation of new contact");
        System.out.println("Please enter phone number: ");
        String phoneNumber = scanner.next();
        System.out.println("Please enter name: ");
        String name = scanner.next();
        System.out.println(contactController.addContact(phoneNumber, name));
        restart();

    }

}
