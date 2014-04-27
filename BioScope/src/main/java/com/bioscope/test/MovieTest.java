package com.bioscope.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.bioscope.config.SpringMongoConfig;
import com.bioscope.domain.Movie;
import com.bioscope.domain.Review;

public class MovieTest {
	public static void main(String[] args) {
		ApplicationContext ctx = 
	             new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		Movie movie = new Movie();
		Review review = new Review();
		movie.setMovieName("Hitler");
		movie.setMovieDescription("This is description");
		//movie.setCriticReview(null);
		//movie.setCasting(null);
		mongoOperation.save(movie);
		Query searchUserQuery = new Query(Criteria.where("movieName").is("Hitler"));
		Movie movieResult = mongoOperation.findOne(searchUserQuery, Movie.class);
		System.out.println("2. find - savedUser : " + movieResult.getMovieDescription());
	}
}
