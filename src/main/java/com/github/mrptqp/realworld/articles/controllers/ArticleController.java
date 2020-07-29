package com.github.mrptqp.realworld.articles.controllers;

import com.github.mrptqp.realworld.articles.dto.ArticleDto;
import com.github.mrptqp.realworld.articles.dto.MultipleArticlesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    @PostMapping("/articles")
    public ArticleDto createArticle(@RequestBody ArticleContent articleContent) {
        return null; //Authentication required, will return an Article
    }

    @GetMapping("/articles/{slug}")
    public ArticleDto getArticle(@PathVariable("slug") String slug) {
        return null; //will return single article
    }

    @PutMapping("/articles/{slug}")
    public ArticleDto updateArticle(@PathVariable("slug") String slug,
                                    @RequestBody UpdatedArticleContent updatedArticleContent
    ) {
        return null; //returns the updated Article
        //The slug also gets updated when the title is changed
    }

    @DeleteMapping("/articles/{slug}")
    public String deleteArticle(@PathVariable("slug") String slug) {
        return "The article has been deleted.";
    }

    @PostMapping("/articles/{slug}/favorite")
    public String addToFavorite(@PathVariable("slug") String slug) {
        return null; //returns the Article
    }

    @DeleteMapping("/articles/{slug}/favorite")
    public String removeFromFavorite(@PathVariable("slug") String slug) {
        return null; //returns the Article
    }

    @GetMapping("/articles")
    public MultipleArticlesDto getArticles(@RequestParam(value = "tag", required = false) String tag,
                                           @RequestParam(value = "author", required = false) String author,
                                           @RequestParam(value = "favorited", required = false) String favoritedBy,
                                           @RequestParam(value = "limit", defaultValue = "20") int limit,
                                           @RequestParam(value = "offset", defaultValue = "0") int offset
    ) {
        return null; //Authentication required, will return an Multiple Articles
    }

    @GetMapping("/articles/feed")
    public MultipleArticlesDto getFeedArticles(@RequestParam(value = "limit", defaultValue = "20") int limit,
                                               @RequestParam(value = "offset", defaultValue = "0") int offset
    ) {
        return null; //will return multiple articles created by followed users, ordered by most recent first.
    }
}
