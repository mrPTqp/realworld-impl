package com.github.mrptqp.realworld.comments.controllers;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@JsonRootName("comment")
@NoArgsConstructor
class CommentContent {
    @NotBlank(message = "can't be empty")
    private String body;
}
