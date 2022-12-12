package ru.kirill98.public_chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.kirill98.public_chat.dto.PersonDto;
import ru.kirill98.public_chat.service.impl.PersonServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

@Controller
public class LoginController {
    @Autowired
    private PersonServiceImpl personService;

    private static final Logger log = Logger.getLogger(LoginController.class.getName());

    @GetMapping("/auth")
    public String authView(Model model, HttpServletRequest request) {
        log.info(String.format("Was open auth view, from address: %s", request.getRemoteAddr()));
        HttpSession session = request.getSession(true);
        String login = (String) session.getAttribute("login");
        System.out.println(login);
        model.addAttribute("userAuth",login);
        model.addAttribute("person", new PersonDto());
        return "auth";
    }
    @PostMapping("/auth")
    public RedirectView auth(@ModelAttribute PersonDto person, HttpServletRequest request) {
        log.info(String.format("Was try auth with login: %s, from address: %s",person.getLogin(), request.getRemoteAddr()));
        if(!(person.getLogin().replaceAll("\\s","").trim().isEmpty())) {
            HttpSession session = request.getSession();
            session.setAttribute("login", person.getLogin());
            person.setAddress(request.getRemoteAddr());
            personService.createNewPerson(person);
            return new RedirectView("/messages");
        } else
            return new RedirectView("/auth");

    }
}
