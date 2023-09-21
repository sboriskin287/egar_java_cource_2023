package ru.egar;

import ru.egar.task.Task;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class TaskGenerator {

    static Task createTask() {
        var random = new Random();
        return new Task()
                .setTitle("My awesome title-" + UUID.randomUUID())
                .setDescription("My awesome description-" + UUID.randomUUID())
                .setStartDate(LocalDateTime.now())
                .setDuration(Duration.ofDays(random.nextInt(1, 7)))
                ;
    }
}
