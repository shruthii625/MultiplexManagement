package com.multiplex.model;



public class Movies {
	private int movieID;
	private String movieName;
	private String movieDetails;
	private String movieGenre;
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDetails() {
		return movieDetails;
	}
	public void setMovieDetails(String movieDetails) {
		this.movieDetails = movieDetails;
	}
	
	
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	@Override
	public String toString() {
		return movieID+"\t"+ movieName + "\t" + movieDetails+"\t"+ movieGenre ;
	}
	
}
