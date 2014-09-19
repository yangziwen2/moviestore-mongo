package net.yangziwen.moviestore.service.impl;

import java.util.List;

import net.yangziwen.moviestore.pojo.MovieInfo;
import net.yangziwen.moviestore.repository.MovieInfoRepository;
import net.yangziwen.moviestore.service.MovieInfoService;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {
	
	@Autowired
	private MovieInfoRepository movieInfoRepository;
	
	@Override
	public MovieInfo getMovieInfoById(String id) {
		return movieInfoRepository.findOne(id);
	}
	
	@Override
	public void saveOrUpdateMovieInfo(MovieInfo movieInfo) {
		movieInfoRepository.save(movieInfo);
	}

	@Override
	public MovieInfo getMovieInfoWithMaxMovieId(String websiteName) {
		List<MovieInfo> list = movieInfoRepository.findByWebsiteNameOrderByMovieIdDesc(websiteName, new PageRequest(0, 1));
		return CollectionUtils.isNotEmpty(list)? list.get(0): null;
	}

}
