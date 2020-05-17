package com.github.mrptqp.realworld.controllers.articles;

import com.github.mrptqp.realworld.models.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetArticleController {

    @GetMapping("/articles/{slug}")
    public Profile getArticle(@PathVariable("slug") String slug) {
        return null; //will return single article
    }
}
