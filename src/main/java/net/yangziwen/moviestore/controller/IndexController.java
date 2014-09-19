package net.yangziwen.moviestore.controller;

import net.yangziwen.moviestore.service.IWebsiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	private IWebsiteService websiteService;
	
	@RequestMapping({"/", "/index"})
	public String index(Model model) {
		return "index";
	}
	
}
