package com.bioscope.client;

import org.springframework.ws.client.core.WebServiceTemplate;

import com.bioscope.domain.userRatingService.ObjectFactory;
import com.bioscope.domain.userRatingService.UserRatingRequest;
import com.bioscope.domain.userRatingService.UserRatingResponse;

public class UserRatingServiceClient {
	private static final ObjectFactory WS_CLIENT_FACTORY = new     ObjectFactory();
    
    private  WebServiceTemplate webServiceTemplate;

    public UserRatingServiceClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }
    public UserRatingResponse addUserRating(String userName,String rating,
    		String movieName,String reviewDescription){
    		UserRatingResponse	 response = null;
		   UserRatingRequest request =  WS_CLIENT_FACTORY.createUserRatingRequest();
		   System.out.println(rating);
		   request.setUserName(userName);
		   request.setMovieName(movieName);
		   request.setRating(rating);
		   request.setTokenName("test");
		   request.setTokenPassword("test");
		   request.setRating(reviewDescription);
		   response = (UserRatingResponse) webServiceTemplate.marshalSendAndReceive(request);
		   return response;
	   }
}
