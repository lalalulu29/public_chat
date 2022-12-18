package ru.kirill98.public_chat.service;

import org.springframework.stereotype.Service;
import ru.kirill98.public_chat.dto.MessageDto;

import java.util.List;


public interface MessageService {
    void createNewMessage(MessageDto message, String login);
    List<MessageDto> findAllMessages();
}
