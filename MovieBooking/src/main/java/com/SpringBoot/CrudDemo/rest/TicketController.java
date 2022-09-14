package com.SpringBoot.CrudDemo.rest;

import com.SpringBoot.CrudDemo.entity.MovieTiming;
import com.SpringBoot.CrudDemo.entity.Ticket;
import com.SpringBoot.CrudDemo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/bookTicket")
    public ResponseEntity<Ticket> bookTicket(@RequestBody Map<String,String> booking){
        return new ResponseEntity<>(ticketService.bookTicket(booking), HttpStatus.CREATED);

    }

    @GetMapping("/displayTicket")
    public List<Ticket> display(){
        return ticketService.displayTicket();
    }

}
