package com.bioscope.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bioscope.domain.Movie;
import com.bioscope.domain.MoviesRequest;
import com.bioscope.domain.MoviesResponse;
import com.bioscope.service.MovieService;

@Endpoint
public class MovieServiceEndPoint {
	private static final String TARGET_NAMESPACE = "http://com/blog/samples/webservices/movieService";

	@Autowired
	private MovieService movieService;
	@PayloadRoot(localPart = "MoviesRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload MoviesResponse getAccountDetails(@RequestPayload MoviesRequest request)
	{
		MoviesResponse response = new MoviesResponse();

		/* call Spring injected service implementation to retrieve account data */
		Movie movie = movieService.getMovieDetails(request.getMovieId());
		response.setMovieDetails(movie);
		return response;
	}

	
}
