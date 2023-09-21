package ru.egar.vacation;

import lombok.AllArgsConstructor;
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
public class Vacation {
    private final LocalDate start;
    private final LocalDate end;
    private Profile employee;
}
