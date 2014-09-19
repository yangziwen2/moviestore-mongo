package net.yangziwen.moviestore.repository.custom;

import java.util.List;

import net.yangziwen.moviestore.pojo.Website;

import org.springframework.data.mongodb.core.query.Query;

public interface WebsiteRepositoryCustom {

	public List<Website> findAll(Query query);
}
