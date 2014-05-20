package com.bioscope.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bioscope.client.MovieDetailsServiceClient;
import com.bioscope.domain.movieService.Movie;
import com.bioscope.domain.movieService.Review;
import com.bioscope.domain.userService.User;
import com.bioscope.service.MovieService;
import com.bioscope.service.UserService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;
	@Autowired
	private MovieDetailsServiceClient movieServiceClient;
	@Autowired
	private HttpSession session;
	@RequestMapping(value="/movieInfo", method=RequestMethod.GET)
	public String movieInfo(@RequestParam String movieName, Model model) {
		System.out.println(movieName);
		Movie movie = movieService.findMovie(movieName);
		model.addAttribute("movie", movie);
		System.out.println(movie.getMovieDescription());
		List<Movie> movies = movieService.geAllMovies();
		System.out.println(movies.size());
		List<Review> listReviews = movieServiceClient.getMovieInfo(movieName).getMovieDetails().getListReviews().getReview();
		model.addAttribute("list", movies);
		model.addAttribute("listReviews", listReviews);
		return "movieInfo";
	}
	@RequestMapping(value="/userInfo", method=RequestMethod.GET)
	public String userInfo(@RequestParam String userName, Model model) {
		User user = movieService.getUserDetails(userName);
		model.addAttribute("user", user);
		List<Movie> movies = movieService.geAllMovies();
		List<String> movieNames =movieService.geRatedMovies(userName);
		System.out.println(movies.size());
		model.addAttribute("listMovies", movieNames);
		model.addAttribute("list", movies);
		
		//model.addAttribute("listMovies", user.getMoviesRated().getMovieName());
		return "userInfo";
	}
	@RequestMapping(value="/rateMovie", method=RequestMethod.POST)
	public String rateMovie( @RequestParam String urating,
			@RequestParam String movieName,
			Model model) {
		System.out.println("----Movie" + movieName);
		userService.getUserRatingServiceDetails((String) session.getAttribute("uname"), movieName, urating, "");
		  String redirectUrl = "movieInfo.html?movieName=" + movieName;
		return "redirect:" + redirectUrl;
	}
	@RequestMapping(value="/listAllMovies", method=RequestMethod.GET)
	public String listAllMovies(@RequestParam String searchTerm, Model model) {
		List<Movie> movies = movieService.getMovies(searchTerm);
		model.addAttribute("lists", movies);
		return "getXml";
	}
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test( Model model) {
		//System.out.println(movieServiceClient.getMovieInfo("Argo").getMovieDetails().getMovieDescription());
		return "test";
	}
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String homePage( Model model) {
		List<Movie> movies = movieService.geAllMovies();
		System.out.println(movies.size());
		model.addAttribute("list", movies);
		return "index";
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage( Model model) {
		List<Movie> movies = movieService.geAllMovies();
		System.out.println(movies.size());
		model.addAttribute("list", movies);
		return "login";
	}
	@RequestMapping(value="/validate", method=RequestMethod.POST)
	public String validate( @RequestParam String uname, @RequestParam  String upass,Model model) {
		System.out.println(uname);
		System.out.println(upass);
		User user = movieService.getPassword(uname);
		List<Movie> movies = movieService.geAllMovies();
		System.out.println(movies.size());
		model.addAttribute("list", movies);
		if( user == null){
			session.setAttribute("uname", null);
			return "failure";
		}else {
			if(BCrypt.checkpw(upass, user.getPassword())){
				session.setAttribute("uname", user.getUserName());
				session.setAttribute("urole", user.getRole());
				return "index";
			}else{
				session.setAttribute("uname", null);
				return "failure";
			}
		}
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model) {

		return "register";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout( Model model){
		session.setAttribute("uname", null);
		session.setAttribute("urole", null);
		return "index";
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
	@RequestMapping(value="/saveMovie", method=RequestMethod.POST)
	public String addMovie( @RequestParam String movieName, 
			@RequestParam  String movieRating,
			@RequestParam String movieDescription,
			@RequestParam String movieCasting,
			Model model) {
		
		movieService.addMovie(movieName,movieRating,movieDescription,movieCasting);
		List<Movie> movies = movieService.geAllMovies();
		System.out.println(movies.size());
		model.addAttribute("list", movies);
		return "index";
	}
	@RequestMapping(value="/addMovie", method=RequestMethod.GET)
	public String addMovie(Model model) {

		return "addMovie";
	}
}
