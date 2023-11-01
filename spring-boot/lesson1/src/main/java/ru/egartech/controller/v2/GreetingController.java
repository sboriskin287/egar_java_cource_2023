package ru.egartech.controller.v2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class GreetingController {

    public GreetingController() {
        System.out.println();
    }

    @GetMapping("/{str}")
    public String greeting(Model model) {
        model.addAttribute("ip", "v2");
        return "greeting";
    }
}
