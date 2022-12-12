package ru.kirill98.public_chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kirill98.public_chat.entity.Log;
import ru.kirill98.public_chat.entity.Message;
import ru.kirill98.public_chat.entity.Person;
import ru.kirill98.public_chat.repository.LogRepository;
import ru.kirill98.public_chat.repository.MessageRepository;
import ru.kirill98.public_chat.repository.PersonRepository;

import java.util.List;

@RestController
public class TestRestController {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private LogRepository logRepository;

    @GetMapping("/get_persons")
    public List<Person> getPersons() {
       return personRepository.findAll();
    }

    @GetMapping("/get_messages")
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @GetMapping("/get_logs")
    public List<Log> getLogs() {
        return logRepository.findAll();
    }
}
