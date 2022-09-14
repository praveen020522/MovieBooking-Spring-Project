package com.SpringBoot.CrudDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.CrudDemo.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
    Movie findByMovieName(String movieName);
}
