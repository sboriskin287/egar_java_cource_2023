package org.example.mapper;

import org.example.dto.ProfileDto;
import org.example.entity.ProfileEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper{
    @NonNull
    public ProfileDto toDto(ProfileEntity source) {
        return new ProfileDto()
                .setId(source.getId())
                .setFullName(String.format("%s %s",
                        source.getFirstName(),
                        source.getLastName()));
    }

    public ProfileEntity toEntity(ProfileDto dto) {
        return new ProfileEntity()
                .setAge(dto.getAge())
                .setFirstName(dto.getFullName().split(" ")[0])
                .setLastName(dto.getFullName().split(" ")[1]);
    }
}
