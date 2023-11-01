package ru.egartech.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.egartech.PortalSingletonBean;
import ru.egartech.ProfileRepo;
import ru.egartech.PortalPrototypeBean;

import java.util.function.Supplier;

@Configuration
public class ProfileRepoConfig {

    @Bean
    public ProfileRepo profileRepo() {
        return new ProfileRepo("jdbc url from app config");
    }

    @Bean
    @Scope(value = "prototype")
    public PortalPrototypeBean portalPrototypeBean() {
        return new PortalPrototypeBean();
    }

    @Bean
    public Supplier<PortalPrototypeBean> portalPrototypeBeanSupplier() {
        return this::portalPrototypeBean;
    }

    @Bean
    public PortalSingletonBean portalSingletonBean(
            Supplier<PortalPrototypeBean> protoFactory) {
        return new PortalSingletonBean(protoFactory);
    }
}
