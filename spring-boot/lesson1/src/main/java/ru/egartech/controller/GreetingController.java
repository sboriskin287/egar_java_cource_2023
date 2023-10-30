package ru.egartech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting(HttpServletRequest req, Model model) {
        model.addAttribute("ip", req.getRemoteHost());
        return "greeting";
    }
}
