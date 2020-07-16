package com.ahmedgaber.hibernate.onetonebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetail {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId = 2;
			
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);
			
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			System.out.println("The associated instructor: " + 
			tempInstructorDetail.getInstructor());
			
			
									
			session.getTransaction().commit();	
			
		} catch (Exception e) {
			session.close();
		} finally {  
			factory.close();
		}
		
	}

}
