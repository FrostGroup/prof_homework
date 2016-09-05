package net.contact_manager.dao;


import java.util.List;
import net.contact_manager.domain.Contact;

public interface ContactDAO {

    public void addContact(Contact contact);

    public List<Contact> listContact();

    public void removeContact(Integer id);
}