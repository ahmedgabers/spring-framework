package com.ahmedgaber.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ahmedgaber.hibernate.Student;

public class QueryStudent {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").list();
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='gaber'").list();
			
			System.out.println("\n\n\nRetrieve gaber");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='gaber' "
					+ "OR s.firstName='Sara'").list();
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%ahmedgaber.io'")
					.list();
			displayStudents(theStudents);
			
			
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close(); 
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
