package com.github.mrptqp.realworld.articles.service;

import com.github.mrptqp.realworld.articles.controllers.ArticleContent;
import com.github.mrptqp.realworld.articles.controllers.UpdatedArticleContent;
import com.github.mrptqp.realworld.articles.dto.ArticleDto;
import com.github.mrptqp.realworld.articles.dto.MultipleArticlesDto;

public class ArticleServiceImpl implements ArticleService {

    @Override
    public ArticleDto createArticle(ArticleContent articleContent) {
        return null;
    }

    @Override
    public ArticleDto getArticle(String slug) {
        return null;
    }

    @Override
    public ArticleDto updateArticle(UpdatedArticleContent updatedArticleContent) {
        return null;
    }

    @Override
    public void deleteArticle(String slug) {

    }

    @Override
    public ArticleDto addToFavorite(String slug) {
        return null;
    }

    @Override
    public ArticleDto removeFromFavorite(String slug) {
        return null;
    }

    @Override
    public MultipleArticlesDto getArticles(String tag, String author, String favoritedBy, int limit, int offset) {
        return null;
    }

    @Override
    public MultipleArticlesDto getFeedArticles(int limit, int offset) {
        return null;
    }
}
