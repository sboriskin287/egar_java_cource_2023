package ru.egartech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.egartech.autoconfig.ProfileService;

@SpringBootApplication
public class PortalApp {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(PortalApp.class, args);
        var pRepo = ctx.getBean(ProfileRepo.class);
        pRepo.printJdbcUrl();
        var pService = ctx.getBean(ProfileService.class);
        pService.getpRepo().printJdbcUrl();

        var bean1 = ctx.getBean(PortalPrototypeBean.class);
        var bean2 = ctx.getBean(PortalPrototypeBean.class);
        System.out.println(bean1 == bean2);

        var sBean = ctx.getBean(PortalSingletonBean.class);
        sBean.printCurrCourse();
        sBean.printCurrCourse();
        sBean.printCurrCourse();
    }
}