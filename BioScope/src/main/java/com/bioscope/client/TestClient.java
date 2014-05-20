package com.bioscope.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bioscope.domain.userRatingService.UserRatingResponse;

public class TestClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
    			new ClassPathXmlApplicationContext("classpath:spring/client-config.xml");
	//	MovieDetailsServiceClient client = (MovieDetailsServiceClient) context.getBean("movieServiceClient");
		//System.out.println(client.getMovieInfo("Argo").getMovieDetails().getMovieDescription());
		UserRatingServiceClient client = (UserRatingServiceClient) context.getBean("userRatingServiceClient");
		UserRatingResponse response = client.addUserRating("pranit", "8.0", "Argo", "test client");
		System.out.println(response.getRatingStatus());
	}
}
