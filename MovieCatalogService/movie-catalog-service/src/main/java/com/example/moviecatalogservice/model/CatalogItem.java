package com.example.moviecatalogservice.model;

public class CatalogItem {
	
	private String name;
	
	private String genre;
	
	private int rating;
	
	public CatalogItem(){
		
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public CatalogItem(String name, String genre, int rating) {
		super();
		this.name = name;
		this.genre = genre;
		this.rating = rating;
	}

}
