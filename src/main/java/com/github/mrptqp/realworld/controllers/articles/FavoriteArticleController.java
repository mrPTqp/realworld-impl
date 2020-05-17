package com.github.mrptqp.realworld.controllers.articles;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FavoriteArticleController {
    @PostMapping("/articles/{slug}/favorite")
    public String favoriteArticle(@PathVariable("slug") String slug) {
        return null; //returns the Article
    }
}