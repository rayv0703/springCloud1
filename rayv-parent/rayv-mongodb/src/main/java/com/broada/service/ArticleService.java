package com.broada.service;

import com.broada.entity.Article;

import java.util.List;

public interface ArticleService {

    void save(Article article);

    void delete(Long id);

    void update(Long id,Article article);

    Article findOne(Long id);

    List<Article> search(Article article);
}
