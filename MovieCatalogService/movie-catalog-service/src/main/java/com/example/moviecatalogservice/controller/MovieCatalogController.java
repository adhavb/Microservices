package com.example.moviecatalogservice.controller;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.moviecatalogservice.model.CatalogItem;
import com.example.moviecatalogservice.model.Movie;
import com.example.moviecatalogservice.model.Rating;
import com.example.moviecatalogservice.model.RatingList;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private WebClient.Builder builder;
	
	@GetMapping("/{userId}")
	@HystrixCommand(fallbackMethod="getFallBackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable String userId){
		RatingList ratings = getRating(userId);
		System.out.println("Ratings "+ratings);
		return ratings.getRatingList().stream().map(rating -> {
			Movie movie = getMovie(rating);
			System.out.println("Movie "+movie.getMovieName());
			/*Movie movie = builder.build()
			.get()
			.uri("http://localhost:8081/movies/"+rating.getMovieId())
			.retrieve()
			.bodyToMono(Movie.class)//Mono means get the response in the future(asynchronously) and not immediately(synchronously)
			.block();*/
			return new CatalogItem(movie.getMovieName(),"Description",rating.getRating());
		}).collect(Collectors.toList());
	}
	private RatingList getRating(String userId){
		RatingList ratings = restTemplate.getForObject("http://RatingDataService/rating/users/"+userId, RatingList.class);
		return ratings;
	}
	
	private Movie getMovie(Rating rating){
		Movie movie = restTemplate.getForObject("http://MovieInfoService/movies/"+rating.getMovieId(), Movie.class);
		return movie;
	}
	
	public List<CatalogItem> getFallBackCatalog(@PathVariable String userId){
		return Arrays.asList(new CatalogItem("No Movie","",0));
	}
}
