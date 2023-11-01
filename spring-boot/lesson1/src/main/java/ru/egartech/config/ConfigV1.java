package ru.egartech.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("ru.egartech.controller.v1")
@EnableWebMvc
public class ConfigV1 {
}
