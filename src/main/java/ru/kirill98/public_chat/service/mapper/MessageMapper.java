package ru.kirill98.public_chat.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.kirill98.public_chat.dto.MessageDto;
import ru.kirill98.public_chat.entity.Message;
import ru.kirill98.public_chat.entity.Person;
import ru.kirill98.public_chat.service.impl.PersonServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MessageMapper {
    @Autowired
    private PersonServiceImpl personService;

    public Message toEntity(MessageDto messageDto) {
        Person personFromDB = personService.findLastPersonWithLogin(messageDto.getPerson());
        Message message = new Message();
        message.setPersonId(personFromDB.getId());
        message.setBody(messageDto.getBody());
        message.setDate(messageDto.getDate());
        return message;
    }
    public MessageDto toDto(Message message) {
        Optional<Person> personFromDB = personService.findPersonById(message.getPersonId());
        MessageDto messageDto = new MessageDto();
        if (personFromDB.isPresent()) {
            messageDto.setPerson(personFromDB.get().getLogin());
            messageDto.setBody(message.getBody());
            messageDto.setDate(message.getDate());
        }


        return messageDto;
    }

    public List<Message> toListOfEntity(List<MessageDto> listOfMessageDto) {
        return listOfMessageDto.stream().map(messageDto -> {
            Person personFromDB = personService.findLastPersonWithLogin(messageDto.getPerson());
            Message message = new Message();
            message.setPersonId(personFromDB.getId());
            message.setBody(messageDto.getBody());
            message.setDate(messageDto.getDate());
            return message;
        }).collect(Collectors.toList());
    }
    public List<MessageDto> toListOfDto(List<Message> listOfMessage) {
        return listOfMessage.stream().map(message -> {
            System.out.println(message.getPersonId());
            Optional<Person> personFromDB = personService.findPersonById(message.getPersonId());
            System.out.println(personFromDB);
            MessageDto messageDto = new MessageDto();
            if (personFromDB.isPresent()) {
                messageDto.setPerson(personFromDB.get().getLogin());
                messageDto.setBody(message.getBody());
                messageDto.setDate(message.getDate());
            }


            return messageDto;
        }).collect(Collectors.toList());
    }
}
