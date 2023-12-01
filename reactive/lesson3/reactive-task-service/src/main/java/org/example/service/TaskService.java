package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.TaskDto;
import org.example.mapper.TaskMapper;
import org.example.repo.TaskRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepo repo;
    private final TaskMapper mapper;

    public Mono<TaskDto> findTask(Integer id) {
        return repo
                .findById(id)
                .delayElement(Duration.ofMinutes(2))
                .map(mapper::toDto);
    }

    public Mono<TaskDto> createTask(TaskDto dto) {
        return Mono
                .just(dto)
                .map(mapper::toEntity)
                .flatMap(repo::save)
                .map(mapper::toDto);
    }

    public Flux<TaskDto> findAllTask() {
        return repo
                .findAll()
                .map(mapper::toDto);
    }

    public Flux<TaskDto> findTasksByProfileId(Integer profileId) {
        return repo
                .findByProfileId(profileId)
                .map(mapper::toDto);
    }
}
