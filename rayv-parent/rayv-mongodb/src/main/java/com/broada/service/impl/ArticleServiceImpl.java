package com.broada.service.impl;

import com.broada.entity.Article;
import com.broada.repositories.ArticleDao;
import com.broada.repositories.ArticleRepository;
import com.broada.service.ArticleService;
import com.mongodb.client.result.UpdateResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    /*@Autowired
    private ArticleRepository repository;*/

    @Autowired
    private MongoTemplate template;

    @Override
    public void save(Article article) {
        articleDao.save(article);
    }

    @Override
    public void delete(Long id) {
        articleDao.deleteById(id);
    }

    @Override
    public void update(Long id,Article article) {
        Optional<Article> optional = articleDao.findById(id);
        if (optional.isPresent()){
            Article article1 = optional.get();
            article1.setTitle(article.getTitle());
            article1.setContent(article.getContent());
        }else {
            throw new RuntimeException("查询ID的文章不存在");
        }
    }

    @Override
    public Article findOne(Long id) {
        Optional<Article> optional = articleDao.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }else {
            return null;
        }
    }

    @Override
    public List<Article> search(Article article) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        //Update update = new Update();
        if (StringUtils.isNotEmpty(article.getTitle())){
            //criteria.and("title").is(article.getTitle());
            //"^.*"+这里拼接你的查询条件字符串+".*$"
            criteria.and("title").regex("^.*"+article.getTitle()+".*$");
        }
        if (StringUtils.isNotEmpty(article.getContent())){
//            criteria.and("content").is(article.getContent());
            criteria.and("content").regex("^"+article.getContent());
        }

        query = query.addCriteria(criteria);
        List<Article> list = template.find(query, Article.class);
        return list;
    }
}
