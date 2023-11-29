package org.example.mapper;

import org.example.dto.ProfileDto;
import org.example.entity.ProfileEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper implements Converter<ProfileEntity, ProfileDto> {
    @Override
    @NonNull
    public ProfileDto convert(ProfileEntity source) {
        return new ProfileDto()
                .setId(source.getId())
                .setFullName(String.format("%s %s",
                        source.getFirstName(),
                        source.getLastName()));
    }
}
