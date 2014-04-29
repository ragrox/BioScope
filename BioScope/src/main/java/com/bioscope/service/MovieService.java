package com.bioscope.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.bioscope.domain.Movie;
import com.bioscope.domain.User;
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

}
