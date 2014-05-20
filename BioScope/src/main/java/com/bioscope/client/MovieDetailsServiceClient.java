package com.bioscope.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.bioscope.domain.movieService.MoviesRequest;
import com.bioscope.domain.movieService.MoviesResponse;
import com.bioscope.domain.movieService.ObjectFactory;

public class MovieDetailsServiceClient {
	 private static final ObjectFactory WS_CLIENT_FACTORY = new     ObjectFactory();
     
	    private  WebServiceTemplate webServiceTemplate;

	    public MovieDetailsServiceClient(WebServiceTemplate webServiceTemplate) {
	        this.webServiceTemplate = webServiceTemplate;
	    }
	           
	   public MoviesResponse getMovieInfo(String name){
		   MoviesResponse response = null;
		   MoviesRequest request = WS_CLIENT_FACTORY.createMoviesRequest();
		   request.setMovieName("Argo");
		   response = (MoviesResponse) webServiceTemplate.marshalSendAndReceive(request);
		   return response;
	   }

	   
}
