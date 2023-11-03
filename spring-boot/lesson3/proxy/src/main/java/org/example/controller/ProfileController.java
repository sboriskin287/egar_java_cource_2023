package org.example.controller;

import org.example.service.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProfileController {

    private final ProfileService pService;

    public ProfileController(ProfileService pService) {
        this.pService = pService;
    }

    @GetMapping("/tx")
    public Map<String, String> executeInTx() {
        var res = pService.someWorkWithDbInTx();
        return Map.of("result", res);
    }

    @GetMapping("/")
    public Map<String, String> execute() {
        var res = pService.someWorkWithDb();
        return Map.of("result", res);
    }
}
