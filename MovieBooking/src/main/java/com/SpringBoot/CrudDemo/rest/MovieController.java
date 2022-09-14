package com.SpringBoot.CrudDemo.rest;

import java.util.List;

import com.SpringBoot.CrudDemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.SpringBoot.CrudDemo.entity.Movie;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;


	@GetMapping("/displayMovie")
	public List<Movie> displayMovie(){
		
		return movieService.displayMovie();
		
	}
	@PostMapping("/addMovie")
	public Movie addMovie(@RequestBody  Movie movie){
		return movieService.addMovie(movie);

	}
}
