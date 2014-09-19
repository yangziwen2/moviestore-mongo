package net.yangziwen.moviestore.service.impl;

import java.util.List;
import java.util.Map;

import net.yangziwen.moviestore.dao.WebsiteDao;
import net.yangziwen.moviestore.pojo.Website;
import net.yangziwen.moviestore.service.IWebsiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebsiteServiceImpl implements IWebsiteService {
	
	@Autowired
	private WebsiteDao websiteDao;

	public Website getWebsiteById(String id) {
		return null;
	}
	
	public Website getWebsiteByName(String name) {
		return null;
	}
	
	public List<Website> getWebsiteListResult(int start, int limit, Map<String, Object> param) {
		return null;
	}
}
