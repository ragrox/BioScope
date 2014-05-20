package com.bioscope.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bioscope.domain.userService.UserRequest;
import com.bioscope.domain.userService.UserResponse;
import com.bioscope.service.MovieService;
import com.bioscope.service.UserService;

@Endpoint
public class UserServiceEndPoint {
	private static final String TARGET_NAMESPACE = "http://com/blog/samples/webservices/userservice";

	@Autowired
	private UserService userService;
	@Autowired
	private MovieService movieService;
	
	@PayloadRoot(localPart = "UserRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload UserResponse getAccountDetails(@RequestPayload UserRequest request)
	{
		UserResponse response = new UserResponse();
		response = movieService.getUserDetailsResponse(request.getUserName());
		/* call Spring injected service implementation to retrieve account data */
		System.out.println("testing");
		
		return response;
	}

	
}
