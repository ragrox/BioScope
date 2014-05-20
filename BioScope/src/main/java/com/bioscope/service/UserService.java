package com.bioscope.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.bioscope.domain.movieService.ListReviews;
import com.bioscope.domain.movieService.Movie;
import com.bioscope.domain.movieService.Review;
import com.bioscope.domain.userRatingService.EnumRatingStatus;
import com.bioscope.domain.userRatingService.User;
import com.bioscope.domain.userRatingService.UserRatingResponse;
import com.bioscope.domain.userService.ListMovies;
import com.bioscope.domain.userService.MoviewRated;
import com.bioscope.domain.userService.UserResponse;
@Service
public class UserService {
	@Autowired
	private MongoTemplate mongoTemplate;
	public com.bioscope.domain.userService.User getUserDetails(String userName) {
		Query searchUserQuery = new Query(Criteria.where("userName").is(userName));
		com.bioscope.domain.userService.User user = mongoTemplate.findOne(searchUserQuery, com.bioscope.domain.userService.User.class);
		return user;
	}

	public UserRatingResponse getUserRatingServiceDetails(String userName,
			String movieName, String rating, String reviewDescription) {
		UserRatingResponse response = new UserRatingResponse();
		Query searchUserQuery = new Query(Criteria.where("movieName").is(movieName));
		Movie movieResult = mongoTemplate.findOne(searchUserQuery, Movie.class);
		ListReviews listReviews = movieResult.getListReviews();
		Review review = new Review();
		review.setMovieName(movieName);
		review.setUserName(userName);
		System.out.println(rating);
		review.setRating(new BigDecimal(rating));
		review.setReviewDescription(reviewDescription);
		List<Review> reviews = listReviews.getReview();
		reviews.add(review);
		mongoTemplate.updateFirst(searchUserQuery, Update.update("listReviews", listReviews), Movie.class);
		response.setRatingStatus(EnumRatingStatus.ACTIVE);
		System.out.println("userName==== " + userName);
		searchUserQuery = new Query(Criteria.where("userName").is(userName));
		MoviewRated rated = mongoTemplate.findOne(searchUserQuery, MoviewRated.class);
		System.out.println(rated == null);
		if( rated ==null){
			rated = new MoviewRated();
			rated.setUserName(userName);
			List<String> list =  rated.getMoviesRated();
			list.add(movieName);
			rated.setMoviesRated(list);
			mongoTemplate.save(rated);
		}else{
			List<String> list =  rated.getMoviesRated();
			list.add(movieName);
			rated.setMoviesRated(list);
			mongoTemplate.updateFirst(searchUserQuery, Update.update("moviesRated", list), MoviewRated.class);
		}
		return response;
	}

};
