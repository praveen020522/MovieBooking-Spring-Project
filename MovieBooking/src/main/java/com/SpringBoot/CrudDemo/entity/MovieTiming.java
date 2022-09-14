package com.SpringBoot.CrudDemo.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="timing",uniqueConstraints = {@UniqueConstraint(columnNames = {"avail_slots","movie_Id","theatre_Id"})})
public class MovieTiming {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="timing_id")
	private int timingId;
	
	@Column(name="avail_slots")
	private String slots;
	
	@Column(name="dates")
	private Date date;
	
	@Column(name="seats")
	private int seats;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="movie_Id")
	private Movie movie;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="theatre_Id")
	private Theatre theatre;

//	@OneToMany(mappedBy="movieTiming",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
//	private Set<Ticket> ticket;
	

	

	public int getTimingId() {
		return timingId;
	}

	public void setTimingId(int timingId) {
		this.timingId = timingId;
	}

	public String getSlots() {
		return slots;
	}

	public void setSlots(String slots) {
		this.slots = slots;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}


	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

//	public Set<Ticket> getTicket() {
//		return ticket;
//	}
//
//	public void setTicket(Set<Ticket> ticket) {
//		this.ticket = ticket;
//	}

	public MovieTiming() {
		
	}

	public MovieTiming(String slots, Date date, int seats) {
		this.slots = slots;
		this.date = date;
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "MovieTiming [timingId=" + timingId + ", slots=" + slots + ", date=" + date + ", seats=" + seats + "]";
	}
	
	
}
