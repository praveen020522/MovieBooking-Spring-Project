package com.SpringBoot.CrudDemo.service;

import com.SpringBoot.CrudDemo.Repo.TheatreRepo;
import com.SpringBoot.CrudDemo.entity.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepo theatreRepo;

    public List<Theatre> displayTheatre(){
        return theatreRepo.findAll();
    }

    public Theatre addTheatre(Theatre theatre){
        return theatreRepo.save(theatre);

    }

    public Theatre getById(int id){
        return theatreRepo.findById(id).get();
    }

    public Theatre getByTheatreName(String theatre){
        return theatreRepo.findByTheatreName(theatre);
    }
}
