package org.example.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskDto {
    private Integer id;
    private String name;
    private String description;

}
