package com.bioscope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bioscope.domain.Movie;
import com.bioscope.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	@RequestMapping(value="/movie-{movieName}", method=RequestMethod.GET)
	public String findMovie(@PathVariable String movieName, Model model) {
	    Movie movie = movieService.findMovie(movieName);
	    model.addAttribute("movie", movie);
	    System.out.println(movie.getMovieDescription());
	    return "movieInfo";
	}
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String homePage( Model model) {
	    return "index";
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage( Model model) {
	    return "login";
	}
	@RequestMapping(value="/validate", method=RequestMethod.POST)
	public String validate( @RequestParam String uname, @RequestParam  String upass,Model model) {
		System.out.println(uname);
		System.out.println(upass);
		//System.out.println(new ShaPasswordEncoder().encodePassword(arg0, arg1));
		System.out.println(new ShaPasswordEncoder());
		String  originalPassword = "password";
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        System.out.println(generatedSecuredPasswordHash);
         
        boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
        System.out.println(matched);
	    return "index";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register( @RequestParam String userName, 
							@RequestParam  String userPassword,
							@RequestParam String userEmail,
							@RequestParam String userConfirmPassword,
							Model model) {
		System.out.println(userName);
		System.out.println(userPassword);
		String  originalPassword = "password";
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        System.out.println(generatedSecuredPasswordHash);
         
        boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
        System.out.println(matched);
	    return "register";
	}
}
