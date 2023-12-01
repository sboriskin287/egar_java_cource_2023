package org.example.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ProfileAndTaskDto {

    private ProfileDto profile;
    private List<TaskDto> tasks;

    @Data
    @Accessors(chain = true)
     public static class ProfileDto {
         private Integer age;
         private String fullName;
     }

     @Data
     @Accessors(chain = true)
     public static class TaskDto {
         private String name;
         private String description;
     }
}
