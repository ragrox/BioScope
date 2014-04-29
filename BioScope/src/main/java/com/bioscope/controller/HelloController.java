package com.bioscope.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bioscope.domain.Movie;
import com.bioscope.service.MovieService;
 
@Controller
@RequestMapping("/searchMovies")
public class HelloController {
 
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="{name}", method = RequestMethod.GET)
	public @ResponseBody Movie getCoffeeInXML(@PathVariable String searchTerm) {
 
		Movie movie = movieService.getMovie(searchTerm);
		//return (Movie[]) list.toArray();
		return movie;
	}
 
}