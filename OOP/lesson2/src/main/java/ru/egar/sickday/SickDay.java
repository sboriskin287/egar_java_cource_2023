package ru.egar.sickday;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.egar.profile.Profile;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
@ToString(exclude = "employee")
public class SickDay {
    private final LocalDate date;
    private Profile employee;
}
