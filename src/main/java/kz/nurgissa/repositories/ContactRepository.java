package kz.nurgissa.repositories;

import kz.nurgissa.db.interfaces.IDB;
import kz.nurgissa.entities.Contact;
import kz.nurgissa.repositories.interfaces.IContactRepository;
import lombok.RequiredArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class ContactRepository implements IContactRepository {
    private final IDB idb;
    @Override
    public void createContactTable(){
        Connection connection = null;
        try {
            connection = idb.getConnection();
            String sql = "CREATE TABLE IF NOT EXISTS contacts (id SERIAL, phoneNumber  varchar(256) , name varchar(256) )";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void createContact(Contact contact){
        Connection connection = null;
        try {
            connection = idb.getConnection();
            String sql = "INSERT INTO contacts (phoneNumber, name) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, contact.getPhoneNumber());
            preparedStatement.setString(2, contact.getName());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Contact getContactById(Integer id){
        Connection connection = null;

        try {
            connection = idb.getConnection();
            String sql = "SELECT * FROM contacts WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Contact contact = new Contact();
            while (resultSet.next()){

                contact.setId(resultSet.getInt("id"));
                contact.setPhoneNumber(resultSet.getString("phoneNumber"));
                contact.setName(resultSet.getString("name"));
            }
            return contact;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override

    public List<Contact> getAllContacts(){
        Connection connection = null;
        try {
            connection = idb.getConnection();
            String sql = "SELECT * FROM contacts";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Contact> contacts = new ArrayList<>();
            while (resultSet.next()){
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setPhoneNumber(resultSet.getString("phoneNumber"));
                contact.setName(resultSet.getString("name"));
                contacts.add(contact);
            }
            return contacts;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Contact updateContact(Integer id, Contact contact){
       Connection connection = null;
       try {
           connection = idb.getConnection();
           String sql = "UPDATE contacts SET phoneNumber = ?, name = ? WHERE id = ?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, contact.getPhoneNumber());
           preparedStatement.setString(2, contact.getName());
           preparedStatement.setInt(3, id);
           ResultSet resultSet =  preparedStatement.executeQuery();
           Contact updatedContact = new Contact();
           while (resultSet.next()){
               updatedContact.setId(resultSet.getInt("id"));
               updatedContact.setPhoneNumber(resultSet.getString("phoneNumber"));
               updatedContact.setName(resultSet.getString("name"));
           }

           return updatedContact;


       } catch (SQLException e){
           e.printStackTrace();
       }
       return null;
    }

    public void deleteContact(Integer id){
        Connection connection = null;
        try {
            connection = idb.getConnection();
            String sql = "DELETE FROM contacts WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
