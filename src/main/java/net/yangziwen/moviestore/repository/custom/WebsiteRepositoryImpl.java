package net.yangziwen.moviestore.repository.custom;

import java.util.Collections;
import java.util.List;

import net.yangziwen.moviestore.pojo.Website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public class WebsiteRepositoryImpl implements WebsiteRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Website> findAll(Query query) {
		if (query == null) {
			return Collections.emptyList();
		}
		return mongoTemplate.find(query, Website.class);
	}

}
