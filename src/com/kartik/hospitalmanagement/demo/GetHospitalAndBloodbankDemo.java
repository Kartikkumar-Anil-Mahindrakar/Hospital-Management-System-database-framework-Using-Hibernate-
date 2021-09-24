package com.kartik.hospitalmanagement.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kartik.hospitalmanagement.entity.BloodBank;
import com.kartik.hospitalmanagement.entity.Hospital;

public class GetHospitalAndBloodbankDemo {

	public static void main(String[] args) {
		SessionFactory sessionfactory = new Configuration()
										.configure()
										.addAnnotatedClass(Hospital.class)
										.addAnnotatedClass(BloodBank.class)
										.buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int theid = 10;
			Hospital newHospital = session.get(Hospital.class, theid);
			
			
			
			System.out.println("Bloodbank : "+newHospital.getBloodbank());
			
			System.out.println("Done!");
			
		}finally {
			session.close();
			sessionfactory.close();
		}
		
		

	}

}
