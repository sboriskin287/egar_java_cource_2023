package ru.egar.profile;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.egar.sickday.SickDay;
import ru.egar.stat.StatPeriod;
import ru.egar.task.Task;
import ru.egar.vacation.Vacation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Profile {
    private String username;
    private String firstName;
    private String lastName;
    private PositionEnum position;
    private GradeEnum grade;
    @Getter(AccessLevel.NONE)
    private List<Vacation> vacations = new ArrayList<>();
    @Getter(AccessLevel.NONE)
    private List<SickDay> sickDays = new ArrayList<>();
    @Getter(AccessLevel.NONE)
    private Set<Task> tasks = new HashSet<>();

    public Profile(String username,
                   String firstName,
                   String lastName,
                   PositionEnum position,
                   GradeEnum grade) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.grade = grade;
    }

    public void addVacation(Vacation v) {
        vacations.add(v);
        v.setEmployee(this);
    }

    public void addSickDay(SickDay sd) {
        sickDays.add(sd);
        sd.setEmployee(this);
    }

    public void addTask(Task t) {
        var tld = t.getStartDate().toLocalDate();
        validateVacations(tld);
        validateSickDays(tld);
        tasks.add(t);
        t.setExecutor(this);
        System.out.println("Task added");
    }

    private void validateSickDays(LocalDate tld) {
        var isExistsSickDay = sickDays
                .stream()
                .anyMatch(s -> s.getDate().equals(tld));
        if (isExistsSickDay) {
            throw new IllegalStateException("Але, я болею");
        }
    }

    private void validateVacations(LocalDate tld) {
        for (Vacation v : vacations) {
            if (tld.isAfter(v.getStart())
                    && tld.isBefore(v.getEnd())) {
                throw new IllegalStateException("Ты чо дурной, я в отпуске");
            }
        }
    }

    public int calculateStat(StatPeriod p) {
        return switch (p) {
            case PER_DAY -> filterTask(this::filterTaskDay);
            case PER_WEEK -> filterTask(this::filterTaskWeek);
            case PER_MONTH -> filterTask(this::filterTaskMonth);
        };
    }

    private boolean filterTaskMonth(Task t) {
        var endLdt = t.getStartDate().plus(t.getDuration()).toLocalDate();
        var now = LocalDate.now();
        var startRange = now.with(now.getMonth());
        var endRange = now.with(now.getMonth()).plusMonths(1);
        return endLdt.isAfter(startRange) && endLdt.isBefore(endRange);
    }

    private boolean filterTaskWeek(Task t) {
        var endLdt = t.getStartDate().plus(t.getDuration()).toLocalDate();
        var startRange = LocalDate.now().with(DayOfWeek.MONDAY);
        var endRange = LocalDate.now().with(DayOfWeek.FRIDAY);
        return endLdt.isAfter(startRange) && endLdt.isBefore(endRange);
    }

    private boolean filterTaskDay(Task t) {
        var endLdt = t.getStartDate().plus(t.getDuration());
        return LocalDateTime.now().equals(endLdt);
    }

    private int filterTask(Predicate<Task> p) {
        return (int) tasks
                .stream()
                .filter(p)
                .count();
    }

}

