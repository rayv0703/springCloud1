package com.broada.controller;

import com.broada.entity.Article;
import com.broada.service.ArticleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "新增文章",notes = "添加文章")
    //@ApiImplicitParam(name = "article",value = "文章实体",required = true,dataType = "article")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public void save(@RequestBody Article article){
        articleService.save(article);
    }
    @ApiOperation(value = "通过ID删除文章",notes = "通过ID删除文章")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        articleService.delete(id);
    }
    @ApiOperation(value = "更新",notes = "通过ID对文章进行更新")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void update(Long id,Article article){
        articleService.update(id,article);
    }
    @ApiOperation(value = "查询",notes = "通过ID查询文章")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Article findOne(Long id){
        Article article = articleService.findOne(id);
        return article;
    }
    @ApiOperation(value = "根据条件进行查询",notes = "根据传入条件进行查询")
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public List<Article> search(@RequestBody @Valid Article article){
        List<Article> articles = new ArrayList<Article>();
        try {
            List<Article> list=articleService.search(article);
            for (Article arti : list) {
                articles.add(arti);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }
}
