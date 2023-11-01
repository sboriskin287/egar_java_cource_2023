package ru.egartech.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import ru.egartech.ProfileRepo;
import ru.egartech.condition.PortalInjectBeanCondition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class ProfileAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    //and
    @ConditionalOnResource(resources = "classpath:portal.properties")
    public ProfileRepo profileRepo() throws IOException {
        var portalConfig = ResourceUtils.getFile("classpath:portal.properties");
        try (FileInputStream fis = new FileInputStream(portalConfig)) {
            Properties props = new Properties();
            props.load(fis);
            return new ProfileRepo(props.getProperty("jdbcUrl"));
        }
    }

    @Bean
    @ConditionalOnProperty(prefix = "enable", name = "service")
    @Conditional(PortalInjectBeanCondition.class)
    public ProfileService profileService() throws IOException {
        return new ProfileService(profileRepo());
    }
}
