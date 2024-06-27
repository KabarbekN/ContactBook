package kz.nurgissa.repositories.interfaces;

import kz.nurgissa.entities.Contact;

import java.util.List;

public interface IContactRepository {
    void createContactTable();
    void createContact(Contact contact);
    Contact getContactById(Integer id);
    List<Contact> getAllContacts();
}
