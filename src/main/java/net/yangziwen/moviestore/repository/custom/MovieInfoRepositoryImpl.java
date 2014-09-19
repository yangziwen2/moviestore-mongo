package net.yangziwen.moviestore.repository.custom;

import java.util.Collections;
import java.util.List;

import net.yangziwen.moviestore.pojo.MovieInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public class MovieInfoRepositoryImpl implements MovieInfoRepositoryCustom {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<MovieInfo> findAll(Query query) {
		if (query == null) {
			return Collections.emptyList();
		}
		return mongoTemplate.find(query, MovieInfo.class);
	}
	
	@Override
	public long count(Query query) {
		if(query == null) {
			return 0;
		}
		return mongoTemplate.count(query, MovieInfo.class);
	}
	
	public List<String> getYearListByWebsiteId(String websiteId) {
//		mongoTemplate.aggregate(aggregation, outputType)
		return null;
	}

}
