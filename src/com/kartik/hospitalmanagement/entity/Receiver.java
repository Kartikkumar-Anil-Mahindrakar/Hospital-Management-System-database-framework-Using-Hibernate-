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
@Table(name = "receiver")
public class Receiver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "rname")
	private String rname;
	@Column(name = "rbloodgroup")
	private String rbloodgroup;
	@Column(name = "rcontactno")
	private long rcontactno;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE
						,CascadeType.PERSIST,CascadeType.REFRESH	})
	@JoinColumn(name = "bloodbank_id")
	private BloodBank bloodbank1;
	
	public Receiver() {
		
	}

	public Receiver(String rname, String rbloodgroup, long rcontactno) {
		this.rname = rname;
		this.rbloodgroup = rbloodgroup;
		this.rcontactno = rcontactno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRbloodgroup() {
		return rbloodgroup;
	}

	public void setRbloodgroup(String rbloodgroup) {
		this.rbloodgroup = rbloodgroup;
	}

	public long getRcontactno() {
		return rcontactno;
	}

	public void setRcontactno(long rcontactno) {
		this.rcontactno = rcontactno;
	}

	

	public BloodBank getBloodbank() {
		return bloodbank1;
	}

	public void setBloodbank(BloodBank bloodbank) {
		this.bloodbank1 = bloodbank;
	}

	@Override
	public String toString() {
		return "Receiver [id=" + id + ", rname=" + rname + ", rbloodgroup=" + rbloodgroup + ", rcontactno=" + rcontactno
				+ ", hospital=" + bloodbank1 + "]";
	}
	
	
}
