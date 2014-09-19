package net.yangziwen.moviestore.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "website")
public class Website extends AbstractEntity {

	@Id
	private String id;
	private String name;
	private String displayName;
	private String homePageUrl;
	private String movieUrlTemplate;
	private String testProxyUrl;
	private Boolean mockPhotoReferer;
	private Integer rank;
	
	public Website() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getHomePageUrl() {
		return homePageUrl;
	}
	public void setHomePageUrl(String homePageUrl) {
		this.homePageUrl = homePageUrl;
	}
	public String getMovieUrlTemplate() {
		return movieUrlTemplate;
	}
	public void setMovieUrlTemplate(String movieUrlTemplate) {
		this.movieUrlTemplate = movieUrlTemplate;
	}
	public String getTestProxyUrl() {
		return testProxyUrl;
	}
	public void setTestProxyUrl(String testProxyUrl) {
		this.testProxyUrl = testProxyUrl;
	}
	public Boolean getMockPhotoReferer() {
		return mockPhotoReferer;
	}
	public void setMockPhotoReferer(Boolean mockPhotoReferer) {
		this.mockPhotoReferer = mockPhotoReferer;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
}
