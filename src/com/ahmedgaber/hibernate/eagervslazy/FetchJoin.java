package com.ahmedgaber.hibernate.eagervslazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoin {

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
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theInstructorId", 
							Instructor.class);
			query.setParameter("theInstructorId", theId);
			Instructor tempInstructor = query.getSingleResult();
			
			
			System.out.println("Instructor: " + tempInstructor);

			
			session.getTransaction().commit();
			
			session.close();
			System.out.println("\n\nThe session is closed\n\n");
			
			
			System.out.println("Courses: " + tempInstructor.getCourses());

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
