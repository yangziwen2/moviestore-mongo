package net.yangziwen.moviestore.repository.custom;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.yangziwen.moviestore.pojo.MovieInfo;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
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

	@Override
	public List<String> getYearListByWebsiteName(String websiteName) {
		TypedAggregation<MovieInfo> aggregation = newAggregation(MovieInfo.class,
			match(where("websiteName").is(websiteName).and("year").ne(null)),
			group("year"),
			project().and("year").as("result"),
			project().and("result").previousOperation(),
			sort(Direction.DESC, "result")
		);
		return transformToStringList(mongoTemplate.aggregate(aggregation, ResultHolder.class).getMappedResults());
	}
	
	@Override
	public List<String> getAreaListByWebsiteName(String websiteName) {
		TypedAggregation<MovieInfo> aggregation = newAggregation(MovieInfo.class,
			match(where("websiteName").is(websiteName).and("area").ne(null)),
			group("area").count().as("cnt"),
			sort(Direction.DESC, "cnt"),
			project().and("area").as("result"),
			project().and("result").previousOperation()
		);
		return transformToStringList(mongoTemplate.aggregate(aggregation, ResultHolder.class).getMappedResults());
	}
	
	@Override
	public List<String> getCategoryListByWebsiteName(String websiteName) {
		TypedAggregation<MovieInfo> aggregation = newAggregation(MovieInfo.class,
			match(where("websiteName").is(websiteName).and("category").ne(null)),
			group("category").count().as("cnt"),
			sort(Direction.DESC, "cnt"),
			project().and("category").as("result"),
			project().and("result").previousOperation()
		);
		return transformToStringList(mongoTemplate.aggregate(aggregation, ResultHolder.class).getMappedResults());
	}
	
	@Override
	public List<String> getSubcategoryListByWebsiteNameAndCategory(String websiteName, String category) {
		TypedAggregation<MovieInfo> aggregation = newAggregation(MovieInfo.class,
			match(where("websiteName").is(websiteName).and("category").is(category).and("subcategory").ne(null)),
			group("subcategory").count().as("cnt"),
			sort(Direction.DESC, "cnt"),
			project().and("subcategory").as("result"),
			project().and("result").previousOperation()
		);
		return transformToStringList(mongoTemplate.aggregate(aggregation, ResultHolder.class).getMappedResults());
	}
	
	private List<String> transformToStringList(List<ResultHolder> holderList) {
		return new ArrayList<String>(CollectionUtils.collect(holderList, new Transformer<ResultHolder, String>(){
			public String transform(ResultHolder holder) {
				return holder.result;
			}
		}));
	}
	
	public static class ResultHolder {
		private String result;
		public void setResult(String result) {
			this.result = result;
		}
	}
	
}
