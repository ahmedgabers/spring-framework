package com.ahmedgaber.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ahmedgaber.springaop.service.TrafficService;
import java.util.logging.Logger;
public class AroundHandleExceptionMain {
	
	private static Logger myLogger = 
			Logger.getLogger(AroundHandleExceptionMain.class.getName());
	
	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		// get the bean from the spring container
		TrafficService theDelayService = context.getBean("trafficService", TrafficService.class);
		
		
		myLogger.info("\nMain Program: Around");
		myLogger.info("Calling getDelay().....");
		
		boolean tripWire = true;
		
		
		try {
			String data = theDelayService.getDelay(tripWire);
			myLogger.info("\nResult: " + data);
		} catch (Exception e) {
			
			myLogger.warning(e.getMessage());
			
			System.out.println("Client: Exception is handled here ....");
		}
		// close the context
		context.close();
		
	}

}
