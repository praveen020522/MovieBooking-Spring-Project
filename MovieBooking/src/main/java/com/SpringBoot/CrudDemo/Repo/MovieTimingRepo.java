package com.SpringBoot.CrudDemo.Repo;

import com.SpringBoot.CrudDemo.entity.Movie;
import com.SpringBoot.CrudDemo.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.CrudDemo.entity.MovieTiming;

public interface MovieTimingRepo extends JpaRepository<MovieTiming, Integer> {
        MovieTiming findBySlotsAndTheatreAndMovie(String slots, Theatre theatre, Movie movie);

}
