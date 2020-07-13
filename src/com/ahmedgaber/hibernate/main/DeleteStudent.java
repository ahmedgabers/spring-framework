package com.ahmedgaber.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ahmedgaber.hibernate.Student;
public class DeleteStudent {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
//			int studentId = 1;
			
			session.beginTransaction();
			
//			Student myStudent = session.get(Student.class, studentId);
			
//			System.out.println("Deleting student: " + myStudent);
//			session.delete(myStudent);
//			session.getTransaction().commit();
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		} finally {
			factory.close();
		}
	}

}
