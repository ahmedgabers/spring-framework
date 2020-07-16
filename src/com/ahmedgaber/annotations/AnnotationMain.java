package com.ahmedgaber.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMain {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContextA.xml");
		
		
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		// call a method on the bean
		
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();

	}

}
