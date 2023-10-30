package ru.egartech.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.egartech.repo.ProfileRepo;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
@RequiredArgsConstructor
public class ProfileReader {

    private final ProfileRepo pRepo;
    private final DataSource ds;

    @PostConstruct
    public void postConstruct() {
        pRepo
                .findProfileWithMyLastName("Водкин")
                .ifPresent(System.out::println);

        pRepo
                .findProfileByFirstNameAndAgeGreaterThan("Петров", 55)
                .ifPresent(System.out::println);
    }
}
