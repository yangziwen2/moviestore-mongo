package net.yangziwen.moviestore.controller;

import java.util.Map;

import net.yangziwen.moviestore.pojo.Website;
import net.yangziwen.moviestore.service.MovieInfoService;
import net.yangziwen.moviestore.service.WebsiteService;
import net.yangziwen.moviestore.util.CommonConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private WebsiteService websiteService;
	@Autowired
	private MovieInfoService movieInfoService;

	@RequestMapping("/{websiteName}/list")
	public String list(
			@PathVariable("websiteName") String websiteName,
			@RequestParam(defaultValue = CommonConstant.DEFAUTL_START_STR) 
			int start,
			@RequestParam(defaultValue = "48") 
			int limit,
			@RequestParam(required = false)
			String year,
			@RequestParam(required = false)
			String area,
			@RequestParam(required = false) 
			String title,
			@RequestParam(required = false)
			String category,
			@RequestParam(required = false)
			String subcategory,
			@RequestParam(required = false)
			String actor,
			Model model) {
		Website website = websiteService.getWebsiteByName(websiteName);
		return "movie/list";
	}
	
	@ResponseBody
	@RequestMapping("/{websiteName}/listSubcategory")
	public Map<String, Object> listSubcategory(
			@PathVariable("websiteName") String websiteName,
			@RequestParam("category") String category) {
		return new ModelMap();
	}
}
