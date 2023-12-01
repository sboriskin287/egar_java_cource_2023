package org.example.repo;

import org.example.entity.TaskEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TaskRepo extends ReactiveCrudRepository<TaskEntity, Integer> {

    Flux<TaskEntity> findByProfileId(Integer profileId);
}
