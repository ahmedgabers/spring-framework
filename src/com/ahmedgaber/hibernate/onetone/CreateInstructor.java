package com.ahmedgaber.hibernate.onetone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor tempInstructor = 
					new Instructor("Ahmed", "Gaber", "ahmed@ahmedgaber.io");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("https://youtube.com/ahmedgabers",
					"Coding");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			
			
			session.getTransaction().commit();
			
			
			
			
			
			
		} finally {
			factory.close();
		}
		
	}

}
