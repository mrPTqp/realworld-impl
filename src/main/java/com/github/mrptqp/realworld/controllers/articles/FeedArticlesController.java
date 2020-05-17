package com.github.mrptqp.realworld.controllers.articles;

import com.github.mrptqp.realworld.models.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FeedArticlesController {

    @GetMapping("/articles/feed")
    public Profile getFeedArticles(@RequestParam(value = "limit", defaultValue = "20") int limit,
                                   @RequestParam(value = "offset", defaultValue = "0") int offset
    ) {


        return null; //will return multiple articles created by followed users, ordered by most recent first.
    }
}
