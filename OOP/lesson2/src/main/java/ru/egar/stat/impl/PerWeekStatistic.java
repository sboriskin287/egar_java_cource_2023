package ru.egar.stat.impl;

import ru.egar.profile.Profile;
import ru.egar.stat.StatPeriod;
import ru.egar.stat.Statistic;
import ru.egar.task.Task;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class PerWeekStatistic implements Statistic {
    @Override
    public int getClosedTasks(Profile p) {
        return p.calculateStat(StatPeriod.PER_WEEK);
    }

    @Deprecated
    private boolean filterTask(Task t) {
        var endLdt = t.getStartDate().plus(t.getDuration()).toLocalDate();
        var startRange = LocalDate.now().with(DayOfWeek.MONDAY);
        var endRange = LocalDate.now().with(DayOfWeek.FRIDAY);
        return endLdt.isAfter(startRange) && endLdt.isBefore(endRange);
    }
}
