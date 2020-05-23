package com.github.mrptqp.realworld.articles.controllers;

import com.github.mrptqp.realworld.profiles.dto.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    @PostMapping("/articles")
    public Profile createArticles(@RequestBody ArticleContent articleContent) {
        return null; //Authentication required, will return an Article
    }

    @DeleteMapping("/articles/{slug}")
    public String deleteArticle(@PathVariable("slug") String slug) {
        return "The article has been deleted.";
    }

    @PostMapping("/articles/{slug}/favorite")
    public String favoriteArticle(@PathVariable("slug") String slug) {
        return null; //returns the Article
    }

    @GetMapping("/articles/feed")
    public Profile getFeedArticles(@RequestParam(value = "limit", defaultValue = "20") int limit,
                                   @RequestParam(value = "offset", defaultValue = "0") int offset
    ) {
        return null; //will return multiple articles created by followed users, ordered by most recent first.
    }

    @GetMapping("/articles/{slug}")
    public Profile getArticle(@PathVariable("slug") String slug) {
        return null; //will return single article
    }

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

    @DeleteMapping("/articles/{slug}/favorite")
    public String unFavoriteArticle(@PathVariable("slug") String slug) {
        return null; //returns the Article
    }

    @PutMapping("/articles/{slug}")
    public Profile updateArticles(@PathVariable("slug") String slug,
                                  @RequestBody UpdatedArticleContent updatedArticleContent
    ) {
        return null; //returns the updated Article
        //The slug also gets updated when the title is changed
    }
}
