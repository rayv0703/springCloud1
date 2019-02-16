package com.broada.service;

import com.broada.entity.Article;
import com.broada.repositories.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ElasticsearchTemplate template;

    @Override
    public void addArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article findById(Integer id) {
        Optional<Article> optional = articleRepository.findById(id);
        if (optional!=null) {
            return optional.get();
        }else {
            return null;
        }

    }

    @Override
    public void updateArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public List<Article> findByKeyword(String Keyword, Pageable pageable) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                //设置查询条件,在该处可以设置多种查询条件
                .withQuery(QueryBuilders.multiMatchQuery(Keyword,"title","content"))
                //设置分页信息
                .withPageable(pageable)
                .build();
        List<Article> articles = template.queryForList(searchQuery, Article.class);
        return articles;
    }

    public List<Article> findNative(String keyword,Pageable pageable){
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery(keyword,"title"))
                .withPageable(pageable)
                .build();
        List<Article> articles = template.queryForList(searchQuery, Article.class);
        return articles;
    }
}
