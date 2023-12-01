package org.example.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Accessors(chain = true)
@Table("profile")
public class ProfileEntity {
    @Id
    @Column("id")
    private Integer id;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("age")
    private Integer age;
}
