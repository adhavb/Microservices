package com.example.ratingdataservice.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ratingdataservice.model.Rating;
import com.example.ratingdataservice.model.RatingList;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@GetMapping("/{movieId}")
	public List<Rating> getRating(@PathVariable String movieId){
		return Collections.singletonList(
				new Rating(1,5)
				);
	}
	
	@GetMapping("/users/{userId}")
	public RatingList getUserRating(@PathVariable String userId){
		List<Rating> ratings = Arrays.asList(
				new Rating(1,4)
				);
		RatingList ratingList = new RatingList();
		ratingList.setRatingList(ratings);
		return ratingList;
	}

}
