package com.broada.service;

import com.broada.entity.Article;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {

    void addArticle(Article article);

    void deleteArticle(Integer id);

    Article findById(Integer id);


    void updateArticle(Article article);

    List<Article> findByKeyword(String Keyword, Pageable pageable);
}
