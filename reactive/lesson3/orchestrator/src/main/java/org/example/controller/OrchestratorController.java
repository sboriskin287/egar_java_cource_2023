package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProfileAndTaskDto;
import org.example.service.OrchestratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrchestratorController {
    private final OrchestratorService service;

    @GetMapping("/{id}")
    public Mono<ProfileAndTaskDto> findProfile(@PathVariable Integer id) {
        return service.findProfileWithTasks(id);
    }
}
