package com.bioscope.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bioscope.domain.userRatingService.UserRatingRequest;
import com.bioscope.domain.userRatingService.UserRatingResponse;
import com.bioscope.service.UserService;

@Endpoint
public class UserRatingServiceEndPoint {
	private static final String TARGET_NAMESPACE = "http://com/blog/samples/webservices/userRatingService";
	
	@Autowired
	private UserService userService;
	@PayloadRoot(localPart = "UserRatingRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload UserRatingResponse getAccountDetails(@RequestPayload UserRatingRequest request)
	{
		UserRatingResponse response = new UserRatingResponse();
			System.out.println("========In ws========");
		/* call Spring injected service implementation to retrieve account data */
		response = userService.getUserRatingServiceDetails(request.getUserName(),request.getMovieName(),request.getRating(),request.getReviewDescription());
		
		return response;
	}

	
}
