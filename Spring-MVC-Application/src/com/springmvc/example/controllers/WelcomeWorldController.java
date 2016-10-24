package com.springmvc.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeWorldController {
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		String msg = "WELCOME! SPRING MVC";
		return new ModelAndView("hellopage", "message", msg);
	}

}
