package com.bioscope.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Movie {
	@Id
	private String id;
	private String movieName;
	private String movieDescription;
	private List<String> casting;
	private List<Review> criticReview;
	private double averageRating;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	public List<String> getCasting() {
		return casting;
	}
	public void setCasting(List<String> casting) {
		this.casting = casting;
	}
	public List<Review> getCriticReview() {
		return criticReview;
	}
	public void setCriticReview(List<Review> criticReview) {
		this.criticReview = criticReview;
	}
	public double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	
	
}
