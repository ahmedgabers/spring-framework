package com.ahmedgaber.annotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService {
	
	private String[] data = {
			"Beware of the wolf in sheep's clothing",
			"Diligience is the mother of good luck",
			"The Journey is the reward"
	};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		
		// pick a random string from the array
		
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		
		return theFortune;
	}

}
