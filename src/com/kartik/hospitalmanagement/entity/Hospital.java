package com.kartik.hospitalmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hospital")
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "hname")
	private String hname;
	
	@Column(name = "location")
	private String Location;
	
	@Column(name = "helpline")
	private long helpline;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bloodbank_id")
	private BloodBank bloodbank;
	
	
	
	public Hospital() {
		
	}
	
	

	



	public Hospital(String hname, String location, long helpline) {
		this.hname = hname;
		Location = location;
		this.helpline = helpline;
	}


	public String getHname() {
		return hname;
	}







	public void setHname(String hname) {
		this.hname = hname;
	}







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public long getHelpline() {
		return helpline;
	}

	public void setHelpline(long helpline) {
		this.helpline = helpline;
	}

	public BloodBank getBloodbank() {
		return bloodbank;
	}

	public void setBloodbank(BloodBank bloodbank) {
		this.bloodbank = bloodbank;
	}



	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hname=" + hname + ", Location=" + Location + ", helpline=" + helpline + "]";
	}
	
	
}
