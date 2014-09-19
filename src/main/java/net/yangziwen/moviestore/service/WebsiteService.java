package net.yangziwen.moviestore.service;

import java.util.List;

import net.yangziwen.moviestore.pojo.Website;

import org.springframework.data.domain.Pageable;

public interface WebsiteService {

	Website getWebsiteById(String id);

	Website getWebsiteByName(String name);

	List<Website> getWebsiteListResult(Pageable pageable);

}
