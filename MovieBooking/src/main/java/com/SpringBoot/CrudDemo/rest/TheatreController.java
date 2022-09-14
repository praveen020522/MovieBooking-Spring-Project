package com.SpringBoot.CrudDemo.rest;

import com.SpringBoot.CrudDemo.entity.Theatre;
import com.SpringBoot.CrudDemo.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {


    @Autowired
    private TheatreService theatreService;


    @GetMapping("/displayTheatre")
    public List<Theatre> displayTheatre(){

        return theatreService.displayTheatre();
    }



    @PostMapping("/addTheatre")
    public Theatre addMovie(@RequestBody Theatre theatre){

        return theatreService.addTheatre(theatre);
    }

}
