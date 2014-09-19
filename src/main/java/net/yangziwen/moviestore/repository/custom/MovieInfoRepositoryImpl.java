package net.yangziwen.moviestore.repository.custom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MovieInfoRepositoryImpl implements MovieInfoRepositoryCustom {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<String> getYearListByWebsiteId(String websiteId) {
//		mongoTemplate.aggregate(aggregation, outputType)
		return null;
	}

}
