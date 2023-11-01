package ru.egartech.autoconfig;

import ru.egartech.ProfileRepo;

public class ProfileService {

    private final ProfileRepo pRepo;

    public ProfileService(ProfileRepo pRepo) {
        this.pRepo = pRepo;
    }

    public ProfileRepo getpRepo() {
        return pRepo;
    }
}
