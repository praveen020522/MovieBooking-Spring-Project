package com.SpringBoot.CrudDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.CrudDemo.entity.Theatre;

public interface TheatreRepo extends JpaRepository<Theatre, Integer> {
        Theatre findByTheatreName(String theatreName);

}
