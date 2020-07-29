package com.github.mrptqp.realworld.articles.controllers;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonRootName("article")
@NoArgsConstructor
public
class UpdatedArticleContent {
    private String title;
    private String description;
    private String body;
}
