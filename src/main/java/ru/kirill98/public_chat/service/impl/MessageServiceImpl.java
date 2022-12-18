package ru.kirill98.public_chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kirill98.public_chat.dto.MessageDto;
import ru.kirill98.public_chat.repository.MessageRepository;
import ru.kirill98.public_chat.service.MessageService;
import ru.kirill98.public_chat.service.mapper.MessageMapper;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private PersonServiceImpl personService;

    @Autowired
    private MessageMapper mapperService;

    @Override
    public void createNewMessage(MessageDto message, String login) {
        message.setPerson(personService.findLastPersonWithLogin(login).getLogin());
        message.setDate(new Date());

        messageRepository.save(mapperService.toEntity(message));
    }

    @Override
    public List<MessageDto> findAllMessages() {

        return mapperService.toListOfDto(messageRepository.findAll());
    }
}
