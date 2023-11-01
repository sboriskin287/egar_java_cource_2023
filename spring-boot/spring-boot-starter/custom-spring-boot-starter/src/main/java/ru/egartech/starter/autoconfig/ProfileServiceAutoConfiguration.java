package ru.egartech.starter.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import ru.egartech.starter.ProfileService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class ProfileServiceAutoConfiguration {

    //@ConditionalOnResource(resources = "classpath:jdbc.properties")
    @ConditionalOnMissingBean
    @Bean
    public ProfileService profileService() throws IOException {
        File file = ResourceUtils.getFile("classpath:jdbc.properties");
        try (InputStream in = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(in);
            return new ProfileService(properties.getProperty("jdbcUrl"));
        }
    }
}
