package ru.kirill98.public_chat.service;

import ru.kirill98.public_chat.dto.PersonDto;
import ru.kirill98.public_chat.entity.Person;

import java.util.List;
import java.util.Optional;


public interface PersonService {
    void createNewPerson(PersonDto personDto);
    List<Person> findAllPeopleWithLogin(String login);
    Person findLastPersonWithLogin(String login);
    Optional<Person> findPersonById(Long id);
}
