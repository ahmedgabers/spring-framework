package com.ahmedgaber.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main")
public class MainController {
	
	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "mainPage";
	}
	
	// need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "congratulations";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		// create the message
		
		String result = "Yo! " + theName;
		
		// add message to the model
		
		model.addAttribute("message", result);
		return "congratulations";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName
			, Model model) {
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		// create the message
		
		String result = "Hey my friend from v3! " + theName;
		
		// add message to the model
		
		model.addAttribute("message", result);
		return "congratulations";
	}
	
	
}
