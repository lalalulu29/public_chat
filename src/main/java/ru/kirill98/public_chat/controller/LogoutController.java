package ru.kirill98.public_chat.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {
    private static final Logger log = Logger.getLogger(LogoutController.class.getName());

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request) {
        log.info(String.format("Was logout, from address: %s", request.getRemoteAddr()));
        request.getSession().removeAttribute("login");
        return new RedirectView("/auth");
    }
}
