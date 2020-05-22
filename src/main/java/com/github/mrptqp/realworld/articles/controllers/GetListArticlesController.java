package com.github.mrptqp.realworld.articles.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetListArticlesController {

    @GetMapping("/articles")
    public String getArticles(@RequestParam(value = "tag", required = false) String tag, //but must return "multiple articles"!!!!!!
                              @RequestParam(value = "author", required = false) String author,
                              @RequestParam(value = "favorited", required = false) String favoritedBy,
                              @RequestParam(value = "limit", defaultValue = "20") int limit,
                              @RequestParam(value = "offset", defaultValue = "0") int offset
    ) {


        return "{\"articles\":[{\"slug\":\"how-to-train-your-dragon\",\"title\":\"How to train your dragon\",\"description\":\"Ever wonder how?\",\"body\":\"It takes a Jacobian\",\"tagList\":[\"dragons\",\"training\"],\"createdAt\":\"2016-02-18T03:22:56.637Z\",\"updatedAt\":\"2016-02-18T03:48:35.824Z\",\"favorited\":false,\"favoritesCount\":0,\"author\":{\"username\":\"jake\",\"bio\":\"I work at statefarm\",\"image\":\"https://i.stack.imgur.com/xHWG8.jpg\",\"following\":false}},{\"slug\":\"how-to-train-your-dragon-2\",\"title\":\"How to train your dragon 2\",\"description\":\"So toothless\",\"body\":\"It a dragon\",\"tagList\":[\"dragons\",\"training\"],\"createdAt\":\"2016-02-18T03:22:56.637Z\",\"updatedAt\":\"2016-02-18T03:48:35.824Z\",\"favorited\":false,\"favoritesCount\":0,\"author\":{\"username\":\"jake\",\"bio\":\"I work at statefarm\",\"image\":\"https://i.stack.imgur.com/xHWG8.jpg\",\"following\":false}}],\"articlesCount\":2}";
        //Authentication required, will return an Article
    }
}
