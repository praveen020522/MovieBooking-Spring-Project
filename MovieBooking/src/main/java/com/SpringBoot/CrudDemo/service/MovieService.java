package com.SpringBoot.CrudDemo.service;

import com.SpringBoot.CrudDemo.Repo.MovieRepo;
import com.SpringBoot.CrudDemo.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRepo;



    public List<Movie> displayMovie(){
        return movieRepo.findAll();
    }

    public Movie addMovie(Movie movie){
        return movieRepo.save(movie);
    }


    public Movie getById(int movieId) {
        return movieRepo.findById(movieId).get();
    }
    public Movie getByMovieName(String movie){
        return movieRepo.findByMovieName(movie);
    }
}
