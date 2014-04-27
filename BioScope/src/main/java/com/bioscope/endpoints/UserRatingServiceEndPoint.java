package com.bioscope.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bioscope.domain.User;
import com.bioscope.domain.UserRatingRequest;
import com.bioscope.domain.UserRatingResponse;
import com.bioscope.service.UserRatingService;

@Endpoint
public class UserRatingServiceEndPoint {
	private static final String TARGET_NAMESPACE = "http://com/blog/samples/webservices/userRatingService";

	@Autowired
	private UserRatingService userRatingService;
	@PayloadRoot(localPart = "UserRatingRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload UserRatingResponse getAccountDetails(@RequestPayload UserRatingRequest request)
	{
		UserRatingResponse response = new UserRatingResponse();

		/* call Spring injected service implementation to retrieve account data */
		User movie = userRatingService.getUserRatingServiceDetails(request.getUserId());
		
		return response;
	}

	
}
