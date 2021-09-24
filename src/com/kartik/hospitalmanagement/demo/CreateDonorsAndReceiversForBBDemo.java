package com.kartik.hospitalmanagement.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kartik.hospitalmanagement.entity.BloodBank;
import com.kartik.hospitalmanagement.entity.Donor;
import com.kartik.hospitalmanagement.entity.Hospital;
import com.kartik.hospitalmanagement.entity.Receiver;

public class CreateDonorsAndReceiversForBBDemo {

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
			int theid = 2;
			System.out.println("Getting Bloodbank .. ");
			BloodBank newBank = session.get(BloodBank.class, theid);
			System.out.println("BloodBank : "+newBank);
			
			Donor donor1 = new Donor("divya","O+",8108651303l);
			Donor donor2 = new Donor("vaibhu","AB+",9004127084l);
			
			Receiver receiver1 = new Receiver("karan","B+",9004989530l);
			System.out.println("Saving Donors and Receivers ...");
			newBank.addDonor(donor1);
			newBank.addDonor(donor2);
			newBank.addReceiver(receiver1);
			
			System.out.println("Done!");
			session.getTransaction().commit();
		}finally {
			session.close();
			sessionfactory.close();
		}
		
		

	}

}
