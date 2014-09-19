package net.yangziwen.moviestore.repository;

import java.util.List;

import net.yangziwen.moviestore.pojo.MovieInfo;
import net.yangziwen.moviestore.repository.custom.MovieInfoRepositoryCustom;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieInfoRepository extends MongoRepository<MovieInfo, String>, MovieInfoRepositoryCustom {

	public List<MovieInfo> findByWebsiteNameOrderByMovieIdDesc(String websiteId, Pageable pageable);
	
}
