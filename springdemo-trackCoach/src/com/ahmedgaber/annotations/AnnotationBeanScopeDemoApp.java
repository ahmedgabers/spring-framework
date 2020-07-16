package com.ahmedgaber.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContextA.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println("alphaCoach equals theCoach: " + (theCoach == alphaCoach));
		System.out.println("theCoach object: " + theCoach);
		System.out.println("alphaCoach object: " + alphaCoach);
		context.close();
	}

}
