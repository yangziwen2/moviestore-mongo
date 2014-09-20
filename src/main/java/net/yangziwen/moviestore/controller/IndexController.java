package net.yangziwen.moviestore.controller;

import java.io.File;
import java.io.IOException;

import net.yangziwen.moviestore.service.WebsiteService;
import net.yangziwen.moviestore.util.DbUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@Autowired
	private WebsiteService websiteService;
	
	@RequestMapping({"/", "/index"})
	public String index(Model model) {
		Pageable pageable = new PageRequest(0, Integer.MAX_VALUE, new Sort(new Order(Direction.DESC, "rank")));
		model.addAttribute("websiteList", websiteService.getWebsiteListResult(pageable));
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/initDb")
	public String importData() {
		String[] collectionNames = {"website", "movieInfo"};
		for(String collectionName: collectionNames) {
			try {
				File dataFile = new ClassPathResource("data/" + collectionName + ".json").getFile();
				DbUtil.importData(dataFile, collectionName, 500);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "success";
	}
	
}
