package kz.nurgissa;

import kz.nurgissa.controller.ContactController;

import kz.nurgissa.db.MySQLDB;
import kz.nurgissa.db.PostgresDB;
import kz.nurgissa.db.interfaces.IDB;

import kz.nurgissa.repositories.ContactRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new MySQLDB();
        ContactRepository contactRepository = new ContactRepository(db);
        ContactController contactController = new ContactController(contactRepository);

        MyApplication myApplication = new MyApplication(contactController);
        myApplication.start();
    }
}