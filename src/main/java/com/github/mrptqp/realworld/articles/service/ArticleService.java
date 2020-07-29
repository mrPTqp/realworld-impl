package com.github.mrptqp.realworld.articles.service;

import com.github.mrptqp.realworld.articles.controllers.ArticleContent;
import com.github.mrptqp.realworld.articles.controllers.UpdatedArticleContent;
import com.github.mrptqp.realworld.articles.dto.ArticleDto;
import com.github.mrptqp.realworld.articles.dto.MultipleArticlesDto;

public interface ArticleService {
    ArticleDto createArticle(ArticleContent articleContent);

    ArticleDto getArticle(String slug);

    ArticleDto updateArticle(UpdatedArticleContent updatedArticleContent);

    void deleteArticle(String slug);

    ArticleDto addToFavorite(String slug);

    ArticleDto removeFromFavorite(String slug);

    MultipleArticlesDto getArticles(
            String tag,
            String author,
            String favoritedBy,
            int limit,
            int offset
    );

    MultipleArticlesDto getFeedArticles(int limit, int offset);
}
