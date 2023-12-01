package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${profile.url}")
    private String profileUrl;

    @Value("${task.url}")
    private String taskUrl;

    @Bean
    public WebClient profileWebClient() {
        return WebClient.create(profileUrl);
    }

    @Bean
    public WebClient taskWebClient() {
        return WebClient.create(taskUrl);
    }
}
