package com.github.mrptqp.realworld.articles.controllers;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.github.mrptqp.realworld.tags.entities.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@JsonRootName("article")
@NoArgsConstructor
class ArticleContent {
    @NotBlank(message = "can't be empty")
    private String title;
    @NotBlank(message = "can't be empty")
    private String description;
    @NotBlank(message = "can't be empty")
    private String body;
    private List<Tag> tagList;
}
