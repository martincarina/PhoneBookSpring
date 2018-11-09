package ru.academits.service;

import ru.academits.bean.ContactValidation;
import ru.academits.entity.Contact;

import java.util.List;

/**
 * Created by Link on 01.09.2017.
 */
public interface ContactService {
    ContactValidation validateContact(Contact contact);

    ContactValidation addContact(Contact contact);

    List<Contact> getAllContacts();

    void removeContacts(String[] ids);
}
