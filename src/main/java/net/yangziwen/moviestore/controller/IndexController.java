package net.yangziwen.moviestore.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.DBCursor;

@Controller
public class IndexController {

	@ResponseBody
	@RequestMapping({"/", "/index"})
	public String index() {
		return "hello world!";
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext*.xml");
		MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);
		System.out.println(mongoTemplate.getCollectionNames());
		DBCursor cursor = mongoTemplate.getCollection("book").find();
		System.out.println(cursor.toArray());
	}
}
