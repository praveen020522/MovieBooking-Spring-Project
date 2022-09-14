package com.SpringBoot.CrudDemo.service;

import com.SpringBoot.CrudDemo.Repo.MovieRepo;
import com.SpringBoot.CrudDemo.Repo.MovieTimingRepo;
import com.SpringBoot.CrudDemo.entity.Movie;
import com.SpringBoot.CrudDemo.entity.MovieTiming;
import com.SpringBoot.CrudDemo.entity.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class MovieTimingService {

    @Autowired
    private MovieTimingRepo movieTimingRepo;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieService movieService;
    public List<MovieTiming> displayTiming(){
        return movieTimingRepo.findAll();
    }

    public MovieTiming addMovieTiming(Map<String,String> timing){


        MovieTiming movieTiming=new MovieTiming();
        Theatre theatre=theatreService.getById(Integer.parseInt(timing.get("theatre")));
        movieTiming.setDate(Date.valueOf(timing.get("date")));
        movieTiming.setSlots(timing.get("slots"));
        movieTiming.setSeats(Integer.parseInt(timing.get("seats")));
        movieTiming.setTheatre(theatre);

        return movieTimingRepo.save(movieTiming);




    }


    public MovieTiming addMovieToSlot(Map<String, String> timing) {

        MovieTiming movieTiming=movieTimingRepo.findById(Integer.valueOf(timing.get("movieTimingId"))).get();
        if(movieTiming!=null){
            Movie movie=movieService.getById(Integer.parseInt(timing.get("movieId")));
            if(movie!=null){
                movieTiming.setMovie(movie);
               return movieTimingRepo.save(movieTiming);
            }
            else throw new NoSuchElementException("movie not found");
        }
        else throw new NoSuchElementException("movie Timing not Found");


    }


    public MovieTiming getByMovieTheatreSlot(String slot, Theatre theatre, Movie movie) {
        return movieTimingRepo.findBySlotsAndTheatreAndMovie(slot,theatre,movie);

    }


    public void update(MovieTiming movieTiming) {
        movieTimingRepo.save(movieTiming);

    }
}

