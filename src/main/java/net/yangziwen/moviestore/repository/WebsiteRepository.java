package net.yangziwen.moviestore.repository;

import net.yangziwen.moviestore.pojo.Website;
import net.yangziwen.moviestore.repository.custom.WebsiteRepositoryCustom;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebsiteRepository extends MongoRepository<Website, String>, WebsiteRepositoryCustom {
	
	public Website getByName(String name);
	
}
