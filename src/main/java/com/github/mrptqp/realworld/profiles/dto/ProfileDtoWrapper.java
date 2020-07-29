package com.github.mrptqp.realworld.profiles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileDtoWrapper {
    @JsonProperty("user")
    private ProfileDto profileDto;
}
