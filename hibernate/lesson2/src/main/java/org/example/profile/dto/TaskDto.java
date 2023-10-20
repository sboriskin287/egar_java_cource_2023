package org.example.profile.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskDto {
    private Integer id;
    private String name;
    private Integer executorId;
}
