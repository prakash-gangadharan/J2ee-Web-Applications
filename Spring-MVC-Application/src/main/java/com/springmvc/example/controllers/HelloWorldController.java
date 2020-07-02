package com.springmvc.example.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Multiple controllers.
 *
 */

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		String msg = "HELLO! SPRING MVC HOW R U";
		return new ModelAndView("hellopage", "message", msg);
	}
	
	/**
	 * Spring MVC Request Response Example
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/hello/user")
	public ModelAndView helloUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request);
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (password.equals("admin")) {
			String message = "HELLO " + name + ", Welcome";
			return new ModelAndView("hellopage", "message", message);
		} else {
			return new ModelAndView("hellopage", "message",
					"Sorry, username or password error");
		}
	}
}
