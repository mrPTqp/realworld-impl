package com.github.mrptqp.realworld.articles.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UnFavoriteArticleController {
    @DeleteMapping("/articles/{slug}/favorite")
    public String unFavoriteArticle(@PathVariable("slug") String slug) {
        return null; //returns the Article
    }
}