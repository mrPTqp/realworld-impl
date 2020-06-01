package com.github.mrptqp.realworld.users.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDtoWrapper {
    @JsonProperty("user")
    private UserDto userDto;
}
