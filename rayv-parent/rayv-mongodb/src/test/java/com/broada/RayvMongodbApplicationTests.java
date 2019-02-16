package com.broada;

import com.broada.entity.Article;
import com.broada.repositories.ArticleDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RayvMongodbApplicationTests {

	@Autowired
	private ArticleDao articleDao;

	@Test
	public void contextLoads() {
		Article article = new Article();
		article.setId(2l);
		article.setTitle("填报租房信息后，我主动撤回了");
		article.setContent("在北京工作4年多的王希，父母还未满60岁，目前也没有买房，她唯一可以申报的只有住房租金这一项");
		articleDao.save(article);
	}

}

