package com.ahmedgaber.hibernate.onetonebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetail {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId = 3;
			
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);
			
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			System.out.println("The associated instructor: " + 
			tempInstructorDetail.getInstructor());
			
			System.out.println("Deleting.... " + tempInstructorDetail);
			
			// remove association before deletion
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(tempInstructorDetail);
									
			session.getTransaction().commit();	
			
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
		} finally {  
			factory.close();
		}
		
	}

}
