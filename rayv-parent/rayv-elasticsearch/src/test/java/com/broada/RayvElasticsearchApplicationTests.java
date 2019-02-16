package com.broada;

import com.broada.controller.ArticleController;
import com.broada.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RayvElasticsearchApplicationTests {

	@Autowired
	ArticleController articleController;

	@Test
	public void contextLoads() {
		Article article = new Article();
		article.setId(3l);
		article.setTitle("李秀领任内蒙古自治区政协党组书记 李佳不再担任");
		article.setContent("据内蒙古新闻网消息，1月4日，内蒙古自治区党委书记、人大常委会主任李纪恒出席自治区政协机关干部大会并讲话。自治区政协党组书记李秀领出席会议。据了解，这是李秀领首次以内蒙古自治区政协党组书记身份公开亮相。");

		articleController.addArticle(article);
	}

}

