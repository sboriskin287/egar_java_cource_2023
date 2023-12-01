package org.example.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Accessors(chain = true)
@Table("tasks")
public class TaskEntity {
    @Id
    @Column("id")
    private Integer id;
    @Column("name")
    private String name;
    @Column("description")
    private String description;
    @Column("profile_id")
    private Integer profileId;
}
