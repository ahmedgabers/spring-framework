package com.xeon.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	// add a new fields for emailAddress and team
	private String emailAddress;
	private String team;
	
	
	// create a constructor
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("Inside setEmailAddress");
		this.emailAddress = emailAddress;
	}



	public String getEmailAddress() {
		return emailAddress;
	}



	public String getTeam() {
		return team;
	}



	public void setTeam(String team) {
		System.out.println("Inside setTeam");
		this.team = team;
	}



	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	
	
	// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter method");
		this.fortuneService = fortuneService;
	}




	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
