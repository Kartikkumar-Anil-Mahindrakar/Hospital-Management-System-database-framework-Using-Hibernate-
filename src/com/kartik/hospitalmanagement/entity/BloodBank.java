package com.kartik.hospitalmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "bloodbank")
public class BloodBank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ward_no")
	private int ward_no;
	
	@Column(name = "availability")
	private boolean availability;
	
	@OneToOne(mappedBy = "bloodbank",
				cascade = {CascadeType.DETACH,CascadeType.MERGE,
							CascadeType.PERSIST,CascadeType.REFRESH})		
	private Hospital hospital;

	@OneToMany(mappedBy = "bloodbank2", cascade = CascadeType.ALL)
	private List<Donor> donors;
	
	
	@OneToMany(mappedBy = "bloodbank1", cascade = CascadeType.ALL)
	private List<Receiver> receivers;

	public BloodBank() {
	}


	public BloodBank(int ward_no, boolean availability) {
		this.ward_no = ward_no;
		this.availability = availability;
		
	}

	

	public void addDonor(Donor newdonor) {
		if(donors == null) {
			donors = new ArrayList<>();
		}
		donors.add(newdonor);
		newdonor.setBloodbank(this);
	}
	
	public void addReceiver(Receiver receiver) {
		if(receivers == null) {
			receivers = new ArrayList<>();
		}
		receivers.add(receiver);
		receiver.setBloodbank(this);
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getWard_no() {
		return ward_no;
	}


	public void setWard_no(int ward_no) {
		this.ward_no = ward_no;
	}


	public boolean isAvailability() {
		return availability;
	}


	public void setAvailability(boolean availability) {
		this.availability = availability;
	}


	public Hospital getHospital() {
		return hospital;
	}


	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	

	public List<Donor> getDonors() {
		return donors;
	}


	public void setDonors(List<Donor> donors) {
		this.donors = donors;
	}


	public List<Receiver> getReceivers() {
		return receivers;
	}


	public void setReceivers(List<Receiver> receivers) {
		this.receivers = receivers;
	}


	@Override
	public String toString() {
		return "BloodBank [id=" + id + ", ward_no=" + ward_no + ", availability=" + availability + "]";
	}
	
	
	
}
