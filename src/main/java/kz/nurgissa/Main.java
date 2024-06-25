package kz.nurgissa;

import kz.nurgissa.db.MySQLDB;
import kz.nurgissa.db.PostgresDB;
import kz.nurgissa.db.interfaces.IDB;
import kz.nurgissa.entities.Contact;
import kz.nurgissa.repositories.ContactRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        ContactRepository contactRepository = new ContactRepository(db);
//        System.out.println(db.getConnection());

        contactRepository.createContactTable();

//        contactRepository.createContact(new Contact("87776662211", "Nurgissa"));

//        System.out.println(contactRepository.getContactById(1));
        contactRepository.getAllContacts().forEach(System.out::println);
    }
}