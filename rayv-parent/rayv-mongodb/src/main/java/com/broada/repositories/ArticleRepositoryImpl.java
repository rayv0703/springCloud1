package com.broada.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository("ArticleRepository")
public class ArticleRepositoryImpl implements ArticleRepository {

    @Autowired
    private MongoTemplate template;
    @Override
    public void findListByPage() {

    }
}
