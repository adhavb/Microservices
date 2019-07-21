package com.example.movieinfoservice.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@GetMapping("/{movieId}")
	public Movie getCatalog(@PathVariable String movieId){
		System.out.println("received request "+movieId);
		return new Movie(1,"Transformer");
				
	}

}