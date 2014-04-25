package com.bioscope.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.bioscope.domain.Movie;
@Service
public class MovieService {
	@Autowired
	private MongoTemplate mongoTemplate;
	public Movie findMovie(String movieName) {
		Query searchUserQuery = new Query(Criteria.where("movieName").is(movieName));
		Movie movieResult = mongoTemplate.findOne(searchUserQuery, Movie.class);
		return movieResult;
	}

}
