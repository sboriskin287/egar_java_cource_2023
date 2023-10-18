package org.example.profile.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ProfileCriteria {
    private Integer id;
    private List<String> firstNames;
    private String lastName;
    private Integer age;
    private Integer fromAgeInclusive;
    private Integer toAgeExclusive;
}
