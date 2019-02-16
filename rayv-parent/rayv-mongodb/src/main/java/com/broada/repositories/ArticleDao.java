package com.broada.repositories;

import com.broada.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleDao extends MongoRepository<Article,Long> {
}
