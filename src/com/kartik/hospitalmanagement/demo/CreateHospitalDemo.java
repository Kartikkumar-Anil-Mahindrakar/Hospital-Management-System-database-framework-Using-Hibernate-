package com.kartik.hospitalmanagement.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kartik.hospitalmanagement.entity.BloodBank;
import com.kartik.hospitalmanagement.entity.Donor;
import com.kartik.hospitalmanagement.entity.Hospital;
import com.kartik.hospitalmanagement.entity.Receiver;

public class CreateHospitalDemo {

	public static void main(String[] args) {
		SessionFactory sessionfactory = new Configuration()
										.configure()
										.addAnnotatedClass(Donor.class)
										.addAnnotatedClass(Receiver.class)
										.addAnnotatedClass(Hospital.class)
										.addAnnotatedClass(BloodBank.class)
										.buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Hospital newHospital = new Hospital("Sarvajani Hospital","Jogeshwari",2234347878l);
			
			BloodBank bloodbank = new BloodBank(13,false);
			newHospital.setBloodbank(bloodbank);
			
			System.out.println("Saving hospital..");
			session.save(newHospital);
			
			System.out.println("Done!");
			
		}finally {
			session.close();
			sessionfactory.close();
		}
		
		

	}

}
