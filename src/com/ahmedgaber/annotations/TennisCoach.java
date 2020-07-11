package com.ahmedgaber.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomService")
	private FortuneService fortuneService;
	
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}
	public TennisCoach() {
		System.out.println(">> inside default constructor");
	}
	
	
	// define a setter method
//	@Autowired 
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println(">> inside doSomeCrazyStuff");
//		this.fortuneService = fortuneService;
//	}
//	
	
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhad volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
