package ru.kirill98.public_chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kirill98.public_chat.dto.PersonDto;
import ru.kirill98.public_chat.entity.Person;
import ru.kirill98.public_chat.repository.PersonRepository;
import ru.kirill98.public_chat.service.PersonService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Person> findAllPeopleWithLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public Person findLastPersonWithLogin(String login) {
        List<Person> people = repository.findByLogin(login);
        return people.get(people.size()-1);
    }

    @Override
    public Optional<Person> findPersonById(Long id) {
        return repository.findById(id);
    }
}
