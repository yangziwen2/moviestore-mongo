package net.yangziwen.moviestore.service;

import java.util.List;
import java.util.Map;

import net.yangziwen.moviestore.pojo.MovieInfo;
import net.yangziwen.moviestore.pojo.Website;
import net.yangziwen.moviestore.util.Page;

public interface MovieInfoService {

	MovieInfo getMovieInfoById(String id);

	void saveOrUpdateMovieInfo(MovieInfo movieInfo);

	MovieInfo getMovieInfoWithMaxMovieId(String websiteName);

	Page<MovieInfo> getMovieInfoPaginateResult(int start, int limit, Map<String, Object> param);

	List<String> getMovieInfoYearListByWebsite(Website website);

	List<String> getMovieInfoAreaListByWebsite(Website website);

	List<String> getCategoryListByWebsite(Website website);

	List<String> getMovieInfoSubcategoryListByWebsiteAndCategory(Website website, String category);

}
