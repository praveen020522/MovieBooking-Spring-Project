package com.SpringBoot.CrudDemo.entity;

import com.SpringBoot.CrudDemo.Enum.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name="ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private int ticketId;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="totalseat")
	private int totalseat;

	@Column(name = "PaymentStatus")
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="movieTiming_id")
	@JsonIgnore
	private MovieTiming movieTiming;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;

	

	public Ticket() {
		
	}



	public Ticket(int amount, int totalseat ) {
		this.amount = amount;
		this.totalseat = totalseat;
	}



	public int getTicketId() {
		return ticketId;
	}



	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public int getTotalseat() {
		return totalseat;
	}



	public void setTotalseat(int totalseat) {
		this.totalseat = totalseat;
	}

	public MovieTiming getMovieTiming() {
		return movieTiming;
	}

	public void setMovieTiming(MovieTiming movieTiming) {
		this.movieTiming = movieTiming;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", amount=" + amount + ", totalseat=" + totalseat
				+ "]";
	}
	
	
	
	
	
}
