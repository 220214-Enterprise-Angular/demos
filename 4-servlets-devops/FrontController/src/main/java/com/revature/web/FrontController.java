package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	/**
	 * This method will be responsible for determining what resource the client is requesting/
	 * It will take in the URL and capture only the end part after "/FrontController/".
	 * 
	 * Once it capture the destication it will call another class called RequestHelper 
	 * which will supply the right functionality
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. Save the URI and rewrite it
		final String URI = request.getRequestURI().replace("/FrontController/", ""); // this leaves nothing but the end
																				     // part like "/login" or "/employees"
		
		
		// 2. Set up a Switch case statement in which we call the appropriate functionality based on the URI returned
		switch(URI) {
		
		case "login":
			// call some processLogin() functionality and pass the request and response objects
			RequestHelper.processLogin(request, response);
			break;
		case "employees":
			// call some type of method to process that and pass the request and response objects
			break;
		}
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
