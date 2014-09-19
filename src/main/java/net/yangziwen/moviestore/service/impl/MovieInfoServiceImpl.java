package net.yangziwen.moviestore.service.impl;

import net.yangziwen.moviestore.dao.MovieInfoDao;
import net.yangziwen.moviestore.service.IMovieInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieInfoServiceImpl implements IMovieInfoService {
	
	@Autowired
	private MovieInfoDao movieInfoDao;

}
