package ru.kirill98.public_chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kirill98.public_chat.dto.MessageDto;
import ru.kirill98.public_chat.service.impl.MessageServiceImpl;
import ru.kirill98.public_chat.service.impl.PersonServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class MessagesController {
    @Autowired
    private PersonServiceImpl personService;

    @Autowired
    private MessageServiceImpl messageService;

    @GetMapping("/messages")
    public String getMessagesView(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        model.addAttribute("userAuth", login);
        model.addAttribute("message", new MessageDto());
        if(login != null) {
            List<MessageDto> listOfMessage = messageService.findAllMessages();
            Collections.reverse(listOfMessage);
            model.addAttribute("messagesFromDb", listOfMessage);
        }
        return "messages";
    }

    @PostMapping("/messages")
    public String sendMessage(@ModelAttribute MessageDto message, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        model.addAttribute("userAuth", login);
        if(login != null) {
            //TODO: -Добавить проверку на наличие символов в теле сообщения
            messageService.createNewMessage(message, login);
            List<MessageDto> listOfMessage = messageService.findAllMessages();
            Collections.reverse(listOfMessage);
            model.addAttribute("messagesFromDb", listOfMessage);
        }
        model.addAttribute("message", new MessageDto());
        return "messages";
    }
}
