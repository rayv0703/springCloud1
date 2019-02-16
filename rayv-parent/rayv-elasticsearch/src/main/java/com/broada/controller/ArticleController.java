package com.broada.controller;

import com.broada.entity.Article;
import com.broada.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 保存
     * @param article
     */
    @ApiOperation(value = "保存es索引库中的信息", notes = "保存在es索引库中的信息")
    //@ApiImplicitParam(name = "Article", value = "文章实体Article", required = true, dataType = "Article")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
    }

    /**
     * 删除
     * @param id
     */
    @ApiOperation(value = "根据索引ID进行删除", notes = "根据索引ID进行删除索引库中的内容")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteArticle(@PathVariable Integer id) {
        articleService.deleteArticle(id);
    }
    @ApiOperation(value = "更新",notes = "更新文章信息")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void updateArticle(@PathVariable Integer id,@RequestBody Article article){
//        Article article1 = articleService.findById(id);
//        article.setTitle(article.getTitle());
//        article.setContent(article.getContent());
//        articleService.addArticle();
        article.setId(id.longValue());
        articleService.updateArticle(article);
    }

    @ApiOperation(value = "查询关键字",notes = "根据关键字进行查询,并分页")
    @RequestMapping(value = "/{keyword}",method = RequestMethod.GET)
    public List<Article> findByKeyword(@PathVariable String keyword){
        Pageable pageable = PageRequest.of(0,5);
        List<Article> articles = articleService.findByKeyword(keyword, pageable);
        return articles;
    }
}
