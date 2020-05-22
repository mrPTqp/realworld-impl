package com.github.mrptqp.realworld.articles.controllers;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.github.mrptqp.realworld.profiles.dto.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateArticleController {

    @PutMapping("/articles/{slug}")
    public Profile updateArticles(
            @PathVariable("slug") String slug,
            @RequestBody UpdatedArticleContent updatedArticleContent
    ) {
        return null; //returns the updated Article
        //The slug also gets updated when the title is changed
    }
}

@Getter
@JsonRootName("article")
@NoArgsConstructor
class UpdatedArticleContent {
    private String title;
    private String description;
    private String body;
}