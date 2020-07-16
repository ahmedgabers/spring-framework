package com.ahmedgaber.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviews {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
												    .addAnnotatedClass(InstructorDetail.class)
												    .addAnnotatedClass(Course.class)
												    .addAnnotatedClass(Review.class)
												    .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman - How To Score One million points");
			
			tempCourse.addReview(new Review("Great Course ... loved it!"));
			tempCourse.addReview(new Review("Cool course, job well done!"));
			tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
			
			System.out.println("Saving the course....");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);
			
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
