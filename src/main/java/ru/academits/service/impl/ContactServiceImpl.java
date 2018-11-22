package ru.academits.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.academits.dao.ContactDao;
import ru.academits.entity.Contact;
import ru.academits.bean.ContactValidation;
import ru.academits.service.ContactService;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

    private boolean isExistContactWithPhone(String phone) {
        List<Contact> contactList = contactDao.getAllContacts();
        for (Contact contact : contactList) {
            if (contact.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ContactValidation validateContact(Contact contact) {
        ContactValidation contactValidation = new ContactValidation();
        contactValidation.setValid(true);
        if (contact.getFirstName().isEmpty()) {
            contactValidation.setValid(false);
            contactValidation.setError("Поле Имя должно быть заполнено.");
            return contactValidation;
        }

        if (contact.getLastName().isEmpty()) {
            contactValidation.setValid(false);
            contactValidation.setError("Поле Фамилия должно быть заполнено.");
            return contactValidation;
        }

        if (contact.getPhone().isEmpty()) {
            contactValidation.setValid(false);
            contactValidation.setError("Поле Телефон должно быть заполнено.");
            return contactValidation;
        }

        if (isExistContactWithPhone(contact.getPhone())) {
            contactValidation.setValid(false);
            contactValidation.setError("Номер телефона не должен дублировать другие номера в телефонной книге.");
            return contactValidation;
        }
        return contactValidation;
    }

    @Override
    public ContactValidation addContact(Contact contact) {
        ContactValidation contactValidation = validateContact(contact);
        if (contactValidation.isValid()) {
            logger.info("Validation of contact is successful");
            contactDao.add(contact);
        }
        return contactValidation;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactDao.getAllContacts();
    }

    @Override
    public void removeContacts(String[] ids) {
        List<Contact> contactList = getAllContacts();
        for (String id : ids) {
            int idToDelete = Integer.parseInt(id);
            contactList.removeIf(contact -> contact.getId() == idToDelete);
        }
    }
}
