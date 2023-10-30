package ru.egartech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.egartech.listener.ProfileWriter;
import ru.egartech.repo.ProfileRepo;

@Configuration
public class MyCoolConfig {

    @Bean
    public ProfileWriter profileWriter(ProfileRepo pRepo) {
        return new ProfileWriter(pRepo);
    }
}
