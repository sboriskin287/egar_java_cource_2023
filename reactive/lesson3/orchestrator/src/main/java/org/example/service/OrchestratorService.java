package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProfileAndTaskDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class OrchestratorService {

    private final WebClient profileWebClient;
    private final WebClient taskWebClient;

    public OrchestratorService(@Qualifier("profileWebClient") WebClient profileWebClient,
                               @Qualifier("taskWebClient") WebClient taskWebClient) {
        this.profileWebClient = profileWebClient;
        this.taskWebClient = taskWebClient;
    }

    public Mono<ProfileAndTaskDto> findProfileWithTasks(Integer id) {
        var profileMono = profileWebClient
                .get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(ProfileAndTaskDto.ProfileDto.class);
        var tasksFlux = taskWebClient
                .get()
                .uri("/profile/" + id)
                .retrieve()
                .bodyToFlux(ProfileAndTaskDto.TaskDto.class)
                .collectList();
        return Mono.zip(profileMono, tasksFlux, (p, t) -> new ProfileAndTaskDto()
                .setProfile(p)
                .setTasks(t));
    }
}
