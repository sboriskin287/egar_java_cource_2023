package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProfileDto;
import org.example.mapper.ProfileMapper;
import org.example.repo.ProfileRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepo repo;
    private final ProfileMapper mapper;

    public Mono<ProfileDto> findProfile(Integer id) {
        return repo
                .findById(id)
                .map(mapper::toDto);
    }

    public Mono<ProfileDto> createProfile(ProfileDto dto) {
        return Mono
                .just(dto)
                .map(mapper::toEntity)
                .flatMap(repo::save)
                .map(mapper::toDto);
    }

    public Flux<ProfileDto> findAllProfiles() {
        return repo
                .findAll()
                .map(mapper::toDto);
    }
}
