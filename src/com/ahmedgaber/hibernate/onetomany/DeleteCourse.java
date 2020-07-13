package com.ahmedgaber.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
												    .addAnnotatedClass(InstructorDetail.class)
												    .addAnnotatedClass(Course.class)
												    .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			
			System.out.println("Creating new courses: ");
			
			
			session.beginTransaction();
			
			
			int theId = 10;
			
			Course tempCourse = session.get(Course.class, theId);
			
			session.delete(tempCourse);
			session.getTransaction().commit();
			
			System.out.println("Done! ");
			
			
			
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
