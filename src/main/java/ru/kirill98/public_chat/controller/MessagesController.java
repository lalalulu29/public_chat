package ru.kirill98.public_chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessagesController {

    @GetMapping("/messages")
    public String getMessagesView() {
        return "messages";
    }
}
