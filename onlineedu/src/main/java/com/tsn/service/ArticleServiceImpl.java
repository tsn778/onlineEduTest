package com.tsn.service;

import com.tsn.mapper.ArticleMapper;
import com.tsn.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
   @Autowired
    ArticleMapper articleMapper;
    @Override
    public List<Article> getArticles() {
        return articleMapper.getArticles();
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public Article getArticleByName(String name) {
        return articleMapper.getArticleByName(name);
    }

    @Override
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public int deleteArticle(Integer id) {
        return articleMapper.deleteArticle(id);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public List<Article> selectArticlesByWord(String word) {
        return articleMapper.selectArticlesByWord(word);
    }

}
