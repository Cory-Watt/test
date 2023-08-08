package com.corywattenberger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloWorldController {

	//return a string from /test1 url
	@GetMapping("/test1")
	@ResponseBody
	
	public String printHello() {

		return "Hello World";
	}
	
	@GetMapping("/test2")
	public String showHelloPage(Model model) {
		//return a model with an attribute named message and return a View named hello using a passed in ModelMap 
		model.addAttribute("message", "Hello Spring MVC Framework");
		
		return "helloPage";
	}
	
	@GetMapping("/test3")
	public ModelAndView printHelloPage(Model model) {
		//create a modelandview and then set an attribute named message and with a view named hello
		ModelAndView mv = new ModelAndView(); 
		mv.addObject("message", new String("Hello world from Model and View!"));
		mv.addObject("message2", new String("Another Hello World from Model and View"));
		
		mv.setViewName("helloPage");
		return mv;
	}
	
	@GetMapping("/test4")
	public String printHelloPage1(@RequestParam("message") String message, Model model) {
		//simply return a Model attribute named message and return a View named hello
		model.addAttribute("message", message);

		return "helloPage";
	}
	
}
