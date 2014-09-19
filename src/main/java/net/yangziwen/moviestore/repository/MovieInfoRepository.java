package net.yangziwen.moviestore.repository;

import net.yangziwen.moviestore.pojo.MovieInfo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieInfoRepository extends MongoRepository<MovieInfo, String> {

}
