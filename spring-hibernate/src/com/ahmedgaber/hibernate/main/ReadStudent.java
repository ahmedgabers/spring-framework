package com.ahmedgaber.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ahmedgaber.hibernate.Student;

public class ReadStudent {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {

			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("ahmed", "gaber", "ahmed@ahmedgaber.io");

			// start a transaction
			
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			
			session.getTransaction().commit();
			
			
			// find out the student's id: primary key
			
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("\nGet Complete: " + myStudent);
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
	}

}
