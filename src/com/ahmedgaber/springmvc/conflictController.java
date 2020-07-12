package com.ahmedgaber.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class conflictController {
	
	@RequestMapping("/processForm")
	public String displayTheForm() {
		return "conflict";
	}
}
