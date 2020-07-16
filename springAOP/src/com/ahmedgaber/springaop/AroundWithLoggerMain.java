package com.ahmedgaber.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ahmedgaber.springaop.service.TrafficService;
import java.util.logging.Logger;
public class AroundWithLoggerMain {
	
	private static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerMain.class.getName());
	
	public static void main(String[] args) {
		

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		// get the bean from the spring container
		TrafficService theDelayService = context.getBean("trafficService", TrafficService.class);
		
		
		myLogger.info("\nMain Program: Around");
		myLogger.info("Calling getDelay().....");
		
		String data = theDelayService.getDelayService();
		
		myLogger.info("\nResult: " + data);

		// close the context
		context.close();
		
	}

}
