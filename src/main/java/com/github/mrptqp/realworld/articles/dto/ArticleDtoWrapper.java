package com.github.mrptqp.realworld.articles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDtoWrapper {
    @JsonProperty("article")
    private ArticleDto articleDto;
}
