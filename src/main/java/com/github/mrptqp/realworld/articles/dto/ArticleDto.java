package com.github.mrptqp.realworld.articles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mrptqp.realworld.tags.entities.Tag;

import java.util.List;

public class ArticleDto {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("body")
    private String body;

    @JsonProperty("tags")
    private List<Tag> tags;
}
