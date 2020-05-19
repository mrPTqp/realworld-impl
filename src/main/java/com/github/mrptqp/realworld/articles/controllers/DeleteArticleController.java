package com.github.mrptqp.realworld.articles.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteArticleController {

    @DeleteMapping("/articles/{slug}")
    public String deleteArticle(@PathVariable("slug") String slug) {
        return "The article has been deleted.";
    }
}