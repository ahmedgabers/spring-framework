package com.ahmedgaber.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ahmedgaber.springaop.service.TrafficService;

public class AroundMain {
	
	public static void main(String[] args) {
		

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		// get the bean from the spring container
		TrafficService theDelayService = context.getBean("trafficService", TrafficService.class);
		
		
		System.out.println("\nMain Program: Around");
		System.out.println("Calling getDelay().....");
		
		String data = theDelayService.getDelayService();
		
		System.out.println("\nResult: " + data);
		
		
		
		
		// close the context
		context.close();

		
		
	}

}
