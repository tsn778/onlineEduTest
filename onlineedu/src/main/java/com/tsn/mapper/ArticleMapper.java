package com.tsn.mapper;

import com.tsn.pojo.Article;
import com.tsn.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {
    List<Article> getArticles();

    Article getArticleById(Integer id);
    Article getArticleByName(String name);
    int addArticle(Article article);
    int deleteArticle(Integer id);
    int updateArticle(Article article);
    List<Article> selectArticlesByWord(String word);
}
