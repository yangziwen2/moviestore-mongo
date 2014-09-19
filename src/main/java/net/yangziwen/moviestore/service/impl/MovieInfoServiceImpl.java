package net.yangziwen.moviestore.service.impl;

import net.yangziwen.moviestore.repository.MovieInfoRepository;
import net.yangziwen.moviestore.service.MovieInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {
	
	@Autowired
	private MovieInfoRepository movieInfoRepository;

}
