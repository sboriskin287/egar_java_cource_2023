package org.example.repo;

import org.example.entity.ProfileEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProfileRepo extends ReactiveCrudRepository<ProfileEntity, Integer> {
}
