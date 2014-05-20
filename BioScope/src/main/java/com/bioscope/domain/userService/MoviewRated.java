package com.bioscope.domain.userService;

import java.util.ArrayList;
import java.util.List;

public class MoviewRated {
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<String> getMoviesRated() {
		if( moviesRated == null)
			return new ArrayList<String>();
		return moviesRated;
	}
	public void setMoviesRated(List<String> moviesRated) {
		this.moviesRated = moviesRated;
	}
	private List<String> moviesRated;
}
