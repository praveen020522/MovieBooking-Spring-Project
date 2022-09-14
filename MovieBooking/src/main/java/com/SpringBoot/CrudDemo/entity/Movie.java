package com.SpringBoot.CrudDemo.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="movie")
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movie_id")
	private int movieid;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="movie_lang")
	private String movieLang;
	
	@Column(name="release_date")
	private Date releaseDate;

	//@OneToMany(mappedBy="movie",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	//private Set<MovieTiming> slot;


	
	public Movie() {
		
	}
	
	public Movie(String movieName, String movieLang, Date releaseDate) {
		this.movieName = movieName;
		this.movieLang = movieLang;
		this.releaseDate = releaseDate;
	}
	

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieLang() {
		return movieLang;
	}

	public void setMovieLang(String movieLang) {
		this.movieLang = movieLang;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	



	/*public Set<MovieTiming> getSlot() {
		return slot;
	}

	public void setSlot(Set<MovieTiming> slot) {
		this.slot = slot;
	}*/

	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", movieName=" + movieName + ", movieLang=" + movieLang + ", releaseDate="
				+ releaseDate + "]";
	}
	
	
	
	
	
	
	
}
