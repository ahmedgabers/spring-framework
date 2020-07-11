package com.ahmedgaber.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomService")
	private FortuneService fortuneService;

	public TennisCoach() {
		System.out.println("TennisCoach >> inside default constructor");
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside PostConstructor");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside PreDestroy");
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
