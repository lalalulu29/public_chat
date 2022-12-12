package ru.kirill98.public_chat.service;

import ru.kirill98.public_chat.dto.PersonDto;


public interface PersonService {
    void createNewPerson(PersonDto personDto);
}
