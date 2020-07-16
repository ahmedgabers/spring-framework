package com.ahmedgaber.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourses {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
												    .addAnnotatedClass(InstructorDetail.class)
												    .addAnnotatedClass(Course.class)
												    .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			
			System.out.println("Creating new courses: ");
			
			
			session.beginTransaction();
			
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class,  theId);
			
			System.out.println("Instructor: " + tempInstructor);
			
			System.out.println("Courses: " + tempInstructor.getCourses());
			
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
