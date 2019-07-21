package com.example.moviecatalogservice.model;

public class Rating {
	
	private int movieId;
	
	private int rating;

	public Rating(){
		
	}
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Rating(int movieId, int rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}

}
