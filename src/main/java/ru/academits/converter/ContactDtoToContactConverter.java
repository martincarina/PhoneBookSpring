package ru.academits.converter;

import ru.academits.converter.generic.GenericConverter;
import ru.academits.dto.ContactDto;
import ru.academits.entity.Contact;

public interface ContactDtoToContactConverter extends GenericConverter<ContactDto, Contact> {
}
