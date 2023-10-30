package ru.egartech.listener;

import lombok.RequiredArgsConstructor;
import ru.egartech.entity.Profile;
import ru.egartech.repo.ProfileRepo;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
public class ProfileWriter {

    private final ProfileRepo pRepo;

    @PostConstruct
    public void postConstruct() {
        pRepo.save(new Profile()
                .setFirstName("Каземир")
                .setLastName("Малевич")
                .setAge(38));
    }
}
