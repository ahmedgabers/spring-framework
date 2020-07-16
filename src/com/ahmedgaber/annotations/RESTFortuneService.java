package com.ahmedgaber.annotations;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "RESTFortuneService is up and running";
	}

}
