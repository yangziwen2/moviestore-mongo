package net.yangziwen.moviestore.service;

import net.yangziwen.moviestore.pojo.MovieInfo;

public interface MovieInfoService {

	MovieInfo getMovieInfoById(String id);

	void saveOrUpdateMovieInfo(MovieInfo movieInfo);

	MovieInfo getMovieInfoWithMaxMovieId(String websiteName);


}
