package ru.egar.stat.impl;

import ru.egar.profile.Profile;
import ru.egar.stat.StatPeriod;
import ru.egar.stat.Statistic;
import ru.egar.task.Task;

import java.time.LocalDateTime;

public class PerDayStatistic implements Statistic {
    @Override
    public int getClosedTasks(Profile p) {
        return p.calculateStat(StatPeriod.PER_DAY);
    }

    @Deprecated
    private boolean filterTask(Task t) {
        var endLdt = t.getStartDate().plus(t.getDuration());
        return LocalDateTime.now().equals(endLdt);
    }
}
