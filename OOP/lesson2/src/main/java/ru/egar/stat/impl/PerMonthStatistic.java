package ru.egar.stat.impl;

import ru.egar.profile.Profile;
import ru.egar.stat.StatPeriod;
import ru.egar.stat.Statistic;
import ru.egar.task.Task;

import java.time.LocalDate;

public class PerMonthStatistic implements Statistic {
    @Override
    public int getClosedTasks(Profile p) {
        return p.calculateStat(StatPeriod.PER_MONTH);
    }

    private boolean filterTask(Task t) {
        var endLdt = t.getStartDate().plus(t.getDuration()).toLocalDate();
        var now = LocalDate.now();
        var startRange = now.with(now.getMonth());
        var endRange = now.with(now.getMonth()).plusMonths(1);
        return endLdt.isAfter(startRange) && endLdt.isBefore(endRange);
    }
}
