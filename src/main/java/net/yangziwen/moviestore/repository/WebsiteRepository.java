package net.yangziwen.moviestore.repository;

import net.yangziwen.moviestore.pojo.Website;
import net.yangziwen.moviestore.repository.base.MyMongoRepository;

public interface WebsiteRepository extends MyMongoRepository<Website, String> {
	
	public Website getByName(String name);
	
}
