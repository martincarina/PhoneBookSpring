package ru.academits.phonebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.academits.converter.ContactDtoToContactConverter;
import ru.academits.converter.ContactToContactDtoConverter;
import ru.academits.dto.ContactDto;
import ru.academits.entity.Contact;
import ru.academits.bean.ContactValidation;
import ru.academits.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/phoneBook/rcp/api/v1")
public class PhoneBookController {

    private static final Logger logger = LoggerFactory.getLogger(PhoneBookController.class);

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactToContactDtoConverter contactToContactDtoConverter;

    @Autowired
    private ContactDtoToContactConverter contactDtoToContactConverter;

    @RequestMapping(value = "getAllContacts", method = RequestMethod.GET)
    public List<ContactDto> getAllContacts() {
        logger.info("called method getAllContacts");
        return contactToContactDtoConverter.convert(contactService.getAllContacts());
    }

    @RequestMapping(value = "addContact", method = RequestMethod.POST)
    public ContactValidation addContact(@RequestBody ContactDto contact) {
        String requestBody = "called method addContact. " + "Request body: first name = " + contact.getFirstName()
                + " last name = " + contact.getLastName() + " phone = " + contact.getPhone();
        logger.info(requestBody);
        Contact contactEntity = contactDtoToContactConverter.convert(contact);
        return contactService.addContact(contactEntity);
    }

    @RequestMapping(value = "removeContacts", method = RequestMethod.POST)
    public void removeContacts(@RequestParam("ids[]") String[] ids) {
        String requestParam = "called method removeContacts. " + "Request parameters: Ids = " + java.util.Arrays.toString(ids);
        logger.info(requestParam);
        contactService.removeContacts(ids);
    }
}


