package com.ahmedgaber.springaop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficService {
	
	public String getDelayService() {
		
		try {
			
			TimeUnit.SECONDS.sleep(5);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Expect heavy traffic this morning";
	}

	public String getDelay(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("Runtime Exception here.....");
		}
		
		
		
		return getDelayService();
	}
	
	

}
