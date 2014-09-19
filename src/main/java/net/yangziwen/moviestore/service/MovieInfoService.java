package net.yangziwen.moviestore.service;

import java.util.Map;

import net.yangziwen.moviestore.pojo.MovieInfo;
import net.yangziwen.moviestore.util.Page;

public interface MovieInfoService {

	MovieInfo getMovieInfoById(String id);

	void saveOrUpdateMovieInfo(MovieInfo movieInfo);

	MovieInfo getMovieInfoWithMaxMovieId(String websiteName);

	Page<MovieInfo> getMovieInfoPaginateResult(int start, int limit, Map<String, Object> param);


}
