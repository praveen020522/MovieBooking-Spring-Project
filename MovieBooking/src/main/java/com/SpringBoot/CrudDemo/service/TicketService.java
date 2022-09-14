package com.SpringBoot.CrudDemo.service;

import com.SpringBoot.CrudDemo.Enum.PaymentStatus;
import com.SpringBoot.CrudDemo.Repo.TicketRepo;
import com.SpringBoot.CrudDemo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TicketService {
    @Autowired
    private TheatreService theatreService;

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieTimingService movieTimingService;

    @Autowired
    private UserService userService;




    public Ticket bookTicket(Map<String,String> booking){
        Theatre theatre=theatreService.getByTheatreName(booking.get("theatre"));

        Movie movie =movieService.getByMovieName((booking.get("movie")));

        User user =userService.getByUserName(booking.get("user"));


        String slot=booking.get("slots");


        MovieTiming movieTiming=movieTimingService.getByMovieTheatreSlot(slot,theatre,movie);


        if(movieTiming!=null&&user!=null){
            int count= Integer.parseInt(booking.get("ticketCount"));
            if(count<movieTiming.getSeats()){
                movieTiming.setSeats(movieTiming.getSeats()-count);
                movieTimingService.update(movieTiming);
                return this.createTicket(count,movieTiming,user);
            }
            else throw new RuntimeException("seats not available");
            }
        else throw new RuntimeException("Invalid Input");
        }


    private Ticket createTicket(int count, MovieTiming timingId,User user) {
        Ticket ticket=new Ticket();
        ticket.setAmount(count*200);
        ticket.setMovieTiming(timingId);
        ticket.setTotalseat(count);
        ticket.setUser(user);
        ticket.setPaymentStatus(PaymentStatus.UNPAID);
       return ticketRepo.save(ticket);
    }

    public List<Ticket> displayTicket(){
        return ticketRepo.findAll();
    }

    public Ticket getById(int id){
        return ticketRepo.findById(id).get();

    }


    public Ticket saveTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }
}
