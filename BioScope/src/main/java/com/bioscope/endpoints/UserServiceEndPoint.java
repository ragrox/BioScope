package com.bioscope.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bioscope.domain.User;
import com.bioscope.domain.UserRequest;
import com.bioscope.domain.UserResponse;
import com.bioscope.service.UserService;

@Endpoint
public class UserServiceEndPoint {
	private static final String TARGET_NAMESPACE = "http://com/blog/samples/webservices/userService";

	@Autowired
	private UserService userService;
	@PayloadRoot(localPart = "UserRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload UserResponse getAccountDetails(@RequestPayload UserRequest request)
	{
		UserResponse response = new UserResponse();

		/* call Spring injected service implementation to retrieve account data */
		User movie = userService.getUserDetails(request.getUserId());
		response.setUserDetails(movie);
		return response;
	}

	
}
