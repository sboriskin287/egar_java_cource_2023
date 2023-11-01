package ru.egartech.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.egartech.starter.ProfileService;

@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootApp.class, args);
        ctx.getBean(ProfileService.class).printJdbc();
    }
}