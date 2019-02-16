package com.broada.repositories;

import com.broada.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
    List<Article> findByTitleOrContent(String title, String content, Pageable pageable);
}
