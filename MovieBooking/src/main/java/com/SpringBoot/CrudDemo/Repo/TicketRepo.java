package com.SpringBoot.CrudDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.CrudDemo.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {


}
