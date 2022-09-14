package com.SpringBoot.CrudDemo.rest;

import com.SpringBoot.CrudDemo.entity.MovieTiming;

import com.SpringBoot.CrudDemo.service.MovieTimingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/movieTiming")
public class MovieTimingController {



    @Autowired
    private MovieTimingService movieTimingService;


    @GetMapping("/displayMovieTiming")
    public List<MovieTiming> displayMovieTiming(){

        return movieTimingService.displayTiming();
    }

    @PostMapping("/addMovieTiming")
    public ResponseEntity<MovieTiming> addMovieTiming(@RequestBody Map<String,String> movieTiming){
        return new ResponseEntity<>(movieTimingService.addMovieTiming(movieTiming),HttpStatus.CREATED);
    }


    @PostMapping("/addMovieToSlot")
    public ResponseEntity<MovieTiming> addMovieTOSlot(@RequestBody Map<String,String> timing) {
            return new ResponseEntity<>(movieTimingService.addMovieToSlot(timing), HttpStatus.CREATED);
        }



}
