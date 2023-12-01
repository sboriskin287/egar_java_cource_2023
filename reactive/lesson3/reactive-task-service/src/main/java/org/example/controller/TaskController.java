package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.TaskDto;
import org.example.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @GetMapping("/{id}")
    public Mono<TaskDto> findTask(@PathVariable Integer id) {
        return service.findTask(id);
    }

    @GetMapping
    public Flux<TaskDto> findAllTasks() {
        return service.findAllTask();
    }

    @PostMapping
    public Mono<TaskDto> createTask(@RequestBody TaskDto dto) {
        return service.createTask(dto);
    }

    @GetMapping("/profile/{id}")
    public Flux<TaskDto> findTasksByProfileId(@PathVariable Integer id) {
        return service.findTasksByProfileId(id);
    }
}
