package ru.kirill98.public_chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kirill98.public_chat.dto.PersonDto;
import ru.kirill98.public_chat.entity.Person;
import ru.kirill98.public_chat.repository.PersonRepository;
import ru.kirill98.public_chat.service.PersonService;

import java.util.Date;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository repository;

    @Override
    public void createNewPerson(PersonDto personDto) {
        Person person = new Person();
        person.setAddress(personDto.getAddress());
        person.setDate(new Date());
        person.setLogin(personDto.getLogin());
        repository.save(person);
    }
}
