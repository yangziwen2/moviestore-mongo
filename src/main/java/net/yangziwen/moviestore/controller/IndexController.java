package net.yangziwen.moviestore.controller;

import net.yangziwen.moviestore.service.WebsiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
