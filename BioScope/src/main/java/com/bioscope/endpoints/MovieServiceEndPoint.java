package com.bioscope.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bioscope.domain.movieService.Movie;
import com.bioscope.domain.movieService.MoviesRequest;
import com.bioscope.domain.movieService.MoviesResponse;
import com.bioscope.service.MovieService;

@Endpoint
public class MovieServiceEndPoint {
	private static final String TARGET_NAMESPACE = "http://com/blog/samples/webservices/movieService";

	@Autowired
	private MovieService movieService;
	@PayloadRoot(localPart = "MoviesRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload MoviesResponse getMovieDetails(@RequestPayload MoviesRequest request)
	{
		MoviesResponse response = new MoviesResponse();

		/* call Spring injected service implementation to retrieve account data */
		Movie movie = movieService.getMovieDetails(request.getMovieName());
		System.out.println(movie.getMovieDescription());
		response.setMovieDetails(movie);
		return response;
	}

	
}
