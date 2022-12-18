package ru.kirill98.public_chat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectFromCoreController {

    @GetMapping("/")
    public RedirectView leaveCoreView() {
        return new RedirectView("/messages");
    }
}
