package net.yangziwen.moviestore.service.impl;

import java.util.List;

import net.yangziwen.moviestore.pojo.Website;
import net.yangziwen.moviestore.repository.WebsiteRepository;
import net.yangziwen.moviestore.service.WebsiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class WebsiteServiceImpl implements WebsiteService {
	
	@Autowired
	private WebsiteRepository websiteRepository;

	@Override
	public Website getWebsiteById(String id) {
		return websiteRepository.getById(id);
	}
	
	@Override
	public Website getWebsiteByName(String name) {
		return websiteRepository.getByName(name);
	}
	
	@Override
	public List<Website> getWebsiteListResult(Pageable pageable) {
		return websiteRepository.findAll(new Query().with(pageable));
	}
}
