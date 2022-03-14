package com.revature.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: When a user goes to the endpoint: localhost:8080/hello
 * this class handles the HTTP request, and delivers the String
 * "Hello World!" to the client directly....
 */

@RestController // REST is an architecture for sending messages/info over HTTP
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String hello() {
		
		return "Testing Spring Boot DevTools";
		
	}	
	
}
