package com.SpringBoot.CrudDemo.entity;

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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="theatre")
public class Theatre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="theatre_id")
	private int theatreId;
	
	@Column(name="theatre_name")
	private String theatreName;
	
	@Column(name="theatre_location")
	private String theatreLocation;
	




	/*@OneToMany(mappedBy="theatre",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<MovieTiming> slot;*/

	public Theatre() {
		
	}

	public Theatre(String theatreName, String theatreLocation) {
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
	}


	public int getTheatreId() {
		return theatreId;
	}


	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}


	public String getTheatreName() {
		return theatreName;
	}


	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}


	public String getTheatreLocation() {
		return theatreLocation;
	}


	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}


	/*public Set<MovieTiming> getSlot() {
		return slot;
	}

	public void setSlot(Set<MovieTiming> slot) {
		this.slot = slot;
	}*/

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreLocation="
				+ theatreLocation + "]";
	}
	
}
