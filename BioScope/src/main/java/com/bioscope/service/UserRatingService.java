package com.bioscope.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.bioscope.domain.userRatingService.UserRatingResponse;
@Service
public class UserRatingService {
	@Autowired
	private MongoTemplate mongoTemplate;
	public UserRatingResponse getUserRatingServiceDetails(String userName, String string, String string2, String string3) {
		UserRatingResponse response = new UserRatingResponse();
		
		return null;
	}

}
