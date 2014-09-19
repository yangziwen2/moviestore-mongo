package net.yangziwen.moviestore.service.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;
import java.util.Map;

import net.yangziwen.moviestore.pojo.MovieInfo;
import net.yangziwen.moviestore.pojo.Website;
import net.yangziwen.moviestore.repository.MovieInfoRepository;
import net.yangziwen.moviestore.service.MovieInfoService;
import net.yangziwen.moviestore.util.Page;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {
	
	@Autowired
	private MovieInfoRepository movieInfoRepository;
	
	@Override
	public MovieInfo getMovieInfoById(String id) {
		return movieInfoRepository.findOne(id);
	}
	
	@Override
	public void saveOrUpdateMovieInfo(MovieInfo movieInfo) {
		movieInfoRepository.save(movieInfo);
	}

	@Override
	public MovieInfo getMovieInfoWithMaxMovieId(String websiteName) {
		List<MovieInfo> list = movieInfoRepository.findByWebsiteNameOrderByMovieIdDesc(websiteName, new PageRequest(0, 1));
		return CollectionUtils.isNotEmpty(list)? list.get(0): null;
	}
	
	@Override
	public Page<MovieInfo> getMovieInfoPaginateResult(int start, int limit, final Map<String, Object> param) {
		Criteria criteria = where("websiteName").is(param.get("websiteName"));
		
		if(param.get("year") != null) {
			criteria.and("year").is(param.get("year"));
		}
		
		if(param.get("area") != null) {
			criteria.and("area").is(param.get("area"));
		}
		
		if(param.get("category") != null) {
			criteria.and("category").is(param.get("category"));
		}
		
		if(param.get("subcategory") != null) {
			criteria.and("subcategory").is(param.get("subcategory"));
		}
		
		if(param.get("title") != null) {
			criteria.and("title").regex(param.get("title").toString());
		}
		
		if(param.get("actor") != null) {
			criteria.and("actors").regex(param.get("actor").toString());
		}
		
		Query query = new Query(criteria).with(new PageRequest(start / limit, limit, new Sort(Direction.DESC, "_id")));
		return new Page<MovieInfo>(start, limit, Long.valueOf(movieInfoRepository.count(query)).intValue(), movieInfoRepository.findAll(query));
	}
	
	@Override
	public List<String> getMovieInfoYearListByWebsite(Website website) {
		return movieInfoRepository.getYearListByWebsiteName(website.getName());
	}
	
	@Override
	public List<String> getMovieInfoAreaListByWebsite(Website website) {
		return movieInfoRepository.getAreaListByWebsiteName(website.getName());
	}
	
	@Override
	public List<String> getCategoryListByWebsite(Website website) {
		return movieInfoRepository.getCategoryListByWebsiteName(website.getName());
	}
	
	@Override
	public List<String> getMovieInfoSubcategoryListByWebsiteAndCategory(Website website, String category) {
		return movieInfoRepository.getSubcategoryListByWebsiteNameAndCategory(website.getName(), category);
	}

}
