package net.contact_manager.service;

import net.contact_manager.domain.Contact;

import java.util.List;

public interface ContactService {

    public void addContact(Contact contact);

    public List<Contact> listContact();

    public void removeContact(Integer id);
}