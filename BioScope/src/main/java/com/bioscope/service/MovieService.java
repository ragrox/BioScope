package com.bioscope.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.bioscope.domain.movieService.ListReviews;
import com.bioscope.domain.movieService.Movie;
import com.bioscope.domain.movieService.Review;
import com.bioscope.domain.userService.ListMovies;
import com.bioscope.domain.userService.MoviewRated;
import com.bioscope.domain.userService.User;
import com.bioscope.domain.userService.UserResponse;
@Service
public class MovieService {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Movie findMovie(String movieName) {
		
		Query searchUserQuery = new Query(Criteria.where("movieId").is(movieName));
		Movie movieResult = mongoTemplate.findOne(searchUserQuery, Movie.class);
		if( movieResult == null){
			searchUserQuery = new Query(Criteria.where("movieName").is(movieName));
			movieResult = mongoTemplate.findOne(searchUserQuery, Movie.class);
		}
		return movieResult;
	}
	public Movie getMovieDetails(String movieId) {
		System.out.println(movieId);
		Query searchUserQuery = new Query(Criteria.where("movieId").is(movieId));
		Movie movieResult = mongoTemplate.findOne(searchUserQuery, Movie.class);
		if( movieResult == null){
			searchUserQuery = new Query(Criteria.where("movieName").is(movieId));
			movieResult = mongoTemplate.findOne(searchUserQuery, Movie.class);
		}
		System.out.println(movieResult);
		return movieResult;
	}
	public void addUser(String userName, String generatedSecuredPasswordHash,
			String userEmail) {
		User user = new User();
		user.setUserName(userName);
		user.setEmail(userEmail);
		user.setPassword(generatedSecuredPasswordHash);
	//	user.setRole("admin");
		
		
		mongoTemplate.save(user);
	}
	public User getPassword(String uname) {
		Query searchUserQuery = new Query(Criteria.where("userName").is(uname));
		User user = mongoTemplate.findOne(searchUserQuery, User.class);
		return user;
	}
	public List<Movie> getMovies(String searchTerm) {
		Query searchUserQuery = new Query(Criteria.where("movieName").regex(searchTerm ,"i"));
		List<Movie> movieResult = mongoTemplate.find(searchUserQuery, Movie.class);
		return movieResult;
	}
	public Movie getMovie(String searchTerm) {
		Query searchUserQuery = new Query(Criteria.where("movieName").regex(searchTerm ,"i"));
		Movie movieResult = mongoTemplate.findOne(searchUserQuery, Movie.class);
		return movieResult;
	}
	public List<Movie> geAllMovies() {
		List<Movie> movieResult = mongoTemplate.findAll(Movie.class);
		return movieResult;
	}
	public void addMovie(String movieName, String movieRating,
			String movieDescription, String movieCasting) {
		Movie movie = new Movie();
		movie.setMovieName(movieName);
		movie.setMovieDescription(movieDescription);
		Review review = new Review();
		review.setRating(new BigDecimal(movieRating));
		String split[] = movieCasting.split(",");
		ArrayList<String> list = new ArrayList<String>();
		for( String cast : split){
			list.add(cast);
		}
		ListReviews listReviews = new ListReviews();
		List<Review> reviews = listReviews.getReview();
		reviews.add(review);
		movie.setListReviews(listReviews);
		movie.setCasting(list);
		mongoTemplate.save(movie);
	}
	public User getUserDetails(String userName) {
		Query searchUserQuery = new Query(Criteria.where("userName").is(userName));
		User user = mongoTemplate.findOne(searchUserQuery, User.class);
		return user;
	}
	public UserResponse getUserDetailsResponse(String userName) {
		Query searchUserQuery = new Query(Criteria.where("userName").is(userName));
		User user = mongoTemplate.findOne(searchUserQuery, User.class);
		UserResponse response = new UserResponse();
		searchUserQuery = new Query(Criteria.where("userName").is(userName));
		MoviewRated rated = mongoTemplate.findOne(searchUserQuery, MoviewRated.class);
		ListMovies listM = new ListMovies();
		listM.getMovieName().addAll(rated.getMoviesRated());
		user.setMoviesRated(listM);
		response.setUserDetails(user);
		return response;
	}
	public List<String> geRatedMovies(String userName) {
		Query searchUserQuery = new Query(Criteria.where("userName").is(userName));
		MoviewRated rated = mongoTemplate.findOne(searchUserQuery, MoviewRated.class);
		return rated.getMoviesRated();
	}


}
