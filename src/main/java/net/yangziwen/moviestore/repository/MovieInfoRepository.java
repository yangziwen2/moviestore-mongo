package net.yangziwen.moviestore.repository;

import java.util.List;

import net.yangziwen.moviestore.pojo.MovieInfo;
import net.yangziwen.moviestore.repository.base.MyMongoRepository;
import net.yangziwen.moviestore.repository.custom.MovieInfoRepositoryCustom;

import org.springframework.data.domain.Pageable;

public interface MovieInfoRepository extends MyMongoRepository<MovieInfo, String>, MovieInfoRepositoryCustom {

	public List<MovieInfo> findByWebsiteNameOrderByMovieIdDesc(String websiteId, Pageable pageable);
	
}
