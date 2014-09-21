package net.yangziwen.moviestore.repository.custom;

import java.util.List;

import net.yangziwen.moviestore.pojo.MovieInfo;

import org.springframework.data.mongodb.core.query.Query;

public interface MovieInfoRepositoryCustom {

//	List<MovieInfo> findAll(Query query);
//
//	long count(Query query);

	List<String> getYearListByWebsiteName(String websiteId);

	List<String> getAreaListByWebsiteName(String websiteName);

	List<String> getCategoryListByWebsiteName(String websiteName);

	List<String> getSubcategoryListByWebsiteNameAndCategory(String websiteName, String category);

}
