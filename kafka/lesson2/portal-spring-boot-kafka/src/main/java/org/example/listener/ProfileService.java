package org.example.listener;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileService {

    private final ProfileRepo repo;

    public ProfileService(ProfileRepo repo) {
        this.repo = repo;
    }

    @Transactional(transactionManager = "transactionManager")
    public void saveProfile(Profile p) {
        repo.save(p);
        if (true) {
            //throw new RuntimeException();
        }
    }
}
