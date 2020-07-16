package com.ahmedgaber.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudents {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
												    .addAnnotatedClass(InstructorDetail.class)
												    .addAnnotatedClass(Course.class)
												    .addAnnotatedClass(Review.class)
												    .addAnnotatedClass(Student.class)
												    .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman - How To Score One million points");
			
			System.out.println("\nSaving the course...");
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);
			
			
			Student tempStudent1 = new Student("ahmed", "gaber", "ahmed@ahmedgaber.org");
			Student tempStudent2 = new Student("mary", "jane", "maryjane@ahmedgaber.org");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			System.out.println("\nSaving students....");
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: " + tempCourse.getStudents());
			
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
