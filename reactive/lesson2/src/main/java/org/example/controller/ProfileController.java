package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProfileDto;
import org.example.service.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService service;

    @GetMapping("/{id}")
    public Mono<ProfileDto> findProfile(@PathVariable Integer id) {
        return service.findProfile(id);
    }

    @GetMapping
    public Flux<ProfileDto> findAllProfiles() {
        return service.findAllProfiles();
    }
}
