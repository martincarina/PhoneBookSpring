package ru.academits.dao;

import ru.academits.entity.Contact;

import java.util.List;

public interface ContactDao {
    List<Contact> getAllContacts();

    void add(Contact contact);
}
