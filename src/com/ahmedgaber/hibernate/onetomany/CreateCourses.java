package com.ahmedgaber.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourses {

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
			Course tempCourse1 = new Course("Learn in anything in 20 hours");
			Course tempCourse2 = new Course("The Piano Guide");
			
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
