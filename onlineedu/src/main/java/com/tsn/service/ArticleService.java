package com.tsn.service;

import com.tsn.pojo.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getArticles();

    Article getArticleById(Integer id);
    Article getArticleByName(String name);
    int addArticle(Article article);
    int deleteArticle(Integer id);
    int updateArticle(Article article);
    List<Article> selectArticlesByWord(String word);
}
