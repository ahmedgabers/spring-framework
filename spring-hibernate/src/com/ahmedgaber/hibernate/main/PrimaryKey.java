package com.ahmedgaber.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ahmedgaber.hibernate.Student;

public class PrimaryKey {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		
			System.out.println("Creating 3 students object...");
			
			Student tempStudent1 = new Student("Squat", "Ten", "squat10@ahmedgaber.io");
			Student tempStudent2 = new Student("Sara", "Jane", "sjay@ahmedgaber.io");
			Student tempStudent3 = new Student("Arafa", "El Zanaty", "arafa@ahmedgaber.io");

			
			session.beginTransaction();
			
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
