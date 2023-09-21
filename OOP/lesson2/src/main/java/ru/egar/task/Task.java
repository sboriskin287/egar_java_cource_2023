package ru.egar.task;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.egar.profile.Profile;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@ToString(exclude = {"creator", "executor"})
public class Task {
    private String title;
    private String description;
    private Profile creator;
    private Profile executor;
    private LocalDateTime startDate;
    private Duration duration;
}
