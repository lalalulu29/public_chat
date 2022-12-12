package ru.kirill98.public_chat.controller;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.kirill98.public_chat.dto.PersonDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {

//    @GetMapping("/auth")
//    public String authView(Model model, HttpServletRequest request) {
//        HttpSession session = request.getSession(true);
//        String login = (String) session.getAttribute("login");
//        System.out.println(login);
//        model.addAttribute("userAuth",login);
//        model.addAttribute("person", new PersonDto());
//        return "auth";
//    }
//    @PostMapping("/auth")
//    public RedirectView auth(@ModelAttribute PersonDto person, HttpServletRequest request) {
//        if(!(person.getLogin().replaceAll("\\s","").isEmpty())) {
//            HttpSession session = request.getSession();
//            session.setAttribute("login", person.getLogin());
//            return new RedirectView("/messages");
//        } else
//            return new RedirectView("/auth");
//
//    }
}
