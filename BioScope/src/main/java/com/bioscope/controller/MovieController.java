package com.bioscope.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bioscope.domain.Movie;
import com.bioscope.domain.User;
import com.bioscope.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private HttpSession session;
	@RequestMapping(value="/movie-{movieName}", method=RequestMethod.GET)
	public String findMovie(@PathVariable String movieName, Model model) {
		Movie movie = movieService.findMovie(movieName);
		model.addAttribute("movie", movie);
		System.out.println(movie.getMovieDescription());
		return "movieInfo";
	}
	@RequestMapping(value="/listAllMovies", method=RequestMethod.GET)
	public String listAllMovies(@RequestParam String searchTerm, Model model) {
		List<Movie> movies = movieService.getMovies(searchTerm);
		model.addAttribute("lists", movies);
		return "getXml";
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
		session.setAttribute("uname", "test");
		User user = movieService.getPassword(uname);
		if( user == null){
			return "failure";
		}else {
			if(BCrypt.checkpw(upass, user.getPassword())){
				session.setAttribute("uname", "test");
				return "index";
			}else{
				return "failure";
			}
		}
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model) {

		return "register";
	}
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser( @RequestParam String userName, 
			@RequestParam  String userPassword,
			@RequestParam String userEmail,
			@RequestParam String userConfirmPassword,
			Model model) {
		System.out.println(userName);
		System.out.println(userPassword);

		String generatedSecuredPasswordHash = BCrypt.hashpw(userPassword, BCrypt.gensalt(12));
		System.out.println(generatedSecuredPasswordHash);

		boolean matched = BCrypt.checkpw(userPassword, generatedSecuredPasswordHash);
		System.out.println(matched);
		movieService.addUser(userName,generatedSecuredPasswordHash,userEmail);
		return "addUser";
	}
}
