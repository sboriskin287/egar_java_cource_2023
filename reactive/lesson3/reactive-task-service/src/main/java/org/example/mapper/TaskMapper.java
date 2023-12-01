package org.example.mapper;

import org.example.dto.TaskDto;
import org.example.entity.TaskEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    @NonNull
    public TaskDto toDto(TaskEntity source) {
        return new TaskDto()
                .setId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription());
    }

    public TaskEntity toEntity(TaskDto dto) {
        return new TaskEntity()
                .setName(dto.getName())
                .setDescription(dto.getDescription());
    }
}
