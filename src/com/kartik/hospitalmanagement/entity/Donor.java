package com.kartik.hospitalmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "donor")
public class Donor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "dname")
	private String dname;
	@Column(name = "dbloodgroup")
	private String dbloodgroup;
	@Column(name = "dcontactno")
	private long dcontactno;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE
						,CascadeType.PERSIST,CascadeType.REFRESH	})
	@JoinColumn(name = "bloodbank_id")
	private BloodBank bloodbank2;
	
	public Donor() {
		
	}
	
	

	public Donor(String dname, String dbloodgroup, long dcontactno) {
		this.dname = dname;
		this.dbloodgroup = dbloodgroup;
		this.dcontactno = dcontactno;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDbloodgroup() {
		return dbloodgroup;
	}

	public void setDbloodgroup(String dbloodgroup) {
		this.dbloodgroup = dbloodgroup;
	}

	public long getDcontactno() {
		return dcontactno;
	}

	public void setDcontactno(long dcontactno) {
		this.dcontactno = dcontactno;
	}

	public BloodBank getBloodbank() {
		return bloodbank2;
	}



	public void setBloodbank(BloodBank bloodbank) {
		this.bloodbank2 = bloodbank;
	}



	@Override
	public String toString() {
		return "Donor [id=" + id + ", dname=" + dname + ", dbloodgroup=" + dbloodgroup + ", dcontactno=" + dcontactno
				+ ", hospital=" + bloodbank2 + "]";
	}
	
	
	
}
