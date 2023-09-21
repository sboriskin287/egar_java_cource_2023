package ru.egar;

import ru.egar.profile.GradeEnum;
import ru.egar.profile.PositionEnum;
import ru.egar.profile.Profile;
import ru.egar.sickday.SickDay;
import ru.egar.stat.Statistic;
import ru.egar.stat.impl.PerDayStatistic;
import ru.egar.stat.impl.PerMonthStatistic;
import ru.egar.stat.impl.PerWeekStatistic;
import ru.egar.task.Task;
import ru.egar.vacation.Vacation;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static ru.egar.TaskGenerator.createTask;

public class Main {
    public static void main(String[] args) {
        Profile p1 = new Profile(
                "ivanov@egar.ru",
                "Иван",
                "Иванов",
                PositionEnum.QA,
                GradeEnum.JUNIOR);
//        Vacation v1 = new Vacation(
//                LocalDate.parse("2023-09-01"),
//                LocalDate.parse("2023-09-15"));
//        p1.addVacation(v1);
//        SickDay sd = new SickDay(LocalDate.now());
//        p1.addSickDay(sd);
        p1.addTask(createTask());
        p1.addTask(createTask());
        p1.addTask(createTask());
        p1.addTask(createTask());
        p1.addTask(createTask());
        System.out.println(p1);

        Statistic statD = new PerDayStatistic();
        System.out.println(statD.getClosedTasks(p1));

        Statistic statW = new PerWeekStatistic();
        System.out.println(statW.getClosedTasks(p1));

        Statistic statM = new PerMonthStatistic();
        System.out.println(statM.getClosedTasks(p1));
    }
}