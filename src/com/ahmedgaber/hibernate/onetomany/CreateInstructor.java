package com.ahmedgaber.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
												    .addAnnotatedClass(InstructorDetail.class)
												    .addAnnotatedClass(Course.class)
												    .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor tempInstructor = 
					new Instructor("Samar", "Randal", "samar@ahmedgaber.io");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("youtube/sarandal", "Video Games");
			
			System.out.println("Creating new Instructor: " + tempInstructor);
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			session.save(tempInstructor);
			session.getTransaction().commit();
			
			System.out.println("Done! " + tempInstructor + " has been saved.");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
			factory.close();
		} finally {
			session.close();
			factory.close();
		}
	}

}
