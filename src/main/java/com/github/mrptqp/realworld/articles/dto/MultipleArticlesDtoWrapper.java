package com.github.mrptqp.realworld.articles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MultipleArticlesDtoWrapper {
    @JsonProperty("articles")
    private MultipleArticlesDto multipleArticlesDto;
}
