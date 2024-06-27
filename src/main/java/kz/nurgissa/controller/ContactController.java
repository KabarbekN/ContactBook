package kz.nurgissa.controller;

import kz.nurgissa.entities.Contact;
import kz.nurgissa.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


public class ContactController {
    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
        createContactTable();
    }

    public void createContactTable(){
        contactRepository.createContactTable();
    }

    public List<Contact> getAllContacts() {
        return contactRepository.getAllContacts();
    }

    public Contact getContactById(Integer id) {
        return contactRepository.getContactById(id);
    }

    public String addContact(String phoneNumber, String name) {
        Contact contact = new Contact(phoneNumber, name);
        contactRepository.createContact(contact);
        return "Contact created";
    }

    public Contact updateContact(Integer id, String phoneNumber, String name) {
        return contactRepository.updateContact(id, new Contact(phoneNumber, name));
    }

    public String deleteContact(Integer id) {
        contactRepository.deleteContact(id);
        return "Contact deleted";
    }




}
