package ru.egartech.springbootapp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.egartech.starter.ProfileService;

@Configuration
public class ProfileServiceConfig {

    @Bean
    @ConditionalOnExpression("${var}")
    @ConditionalOnMissingClass
    public ProfileService profileService() {
        return new ProfileService("appJdbc");
    }
}
