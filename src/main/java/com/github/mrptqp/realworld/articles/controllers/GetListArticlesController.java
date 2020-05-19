package com.github.mrptqp.realworld.articles.controllers;

import com.github.mrptqp.realworld.profiles.models.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetListArticlesController {

    @GetMapping("/articles")
    public Profile getArticles(@RequestParam(value = "tag", required = false) String tag,
                               @RequestParam(value = "author", required = false) String author,
                               @RequestParam(value = "favorited", required = false) String favoritedBy,
                               @RequestParam(value = "limit", defaultValue = "20") int limit,
                               @RequestParam(value = "offset", defaultValue = "0") int offset
    ) {


        return null; //will return multiple articles, ordered by most recent first
    }
}
