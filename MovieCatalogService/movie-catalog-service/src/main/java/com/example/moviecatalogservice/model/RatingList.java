package com.example.moviecatalogservice.model;

import java.util.List;

public class RatingList {
	
	private List ratingList;
	
	public RatingList(){
		
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

}
