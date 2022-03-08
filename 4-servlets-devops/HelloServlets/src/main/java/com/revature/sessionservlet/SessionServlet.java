package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

public class SessionServlet extends HttpServlet {

	/**
	 * When this servlet recieves a GET request, we will instantiate a superVIllain object and store him in 
	 * the session
	 * 
	 * We will then create another Servlet called HelperSessionServlet whose job it is to retrieve
	 * objects from the session.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// instantiate a villain object
		SuperVillain vill = new SuperVillain("Mud Man", "mud armor", 5);
		
		// capture the HTTP session from the request object
		HttpSession session = request.getSession();
		
		// save the villain object to the session
		session.setAttribute("the-villain", vill); // we are setting a key to this object to retrieve it later
		
		// use the print writer to print out to the browser that the villain is stored in the session
		PrintWriter out = response.getWriter();
		String jsonString = new ObjectMapper().writeValueAsString(vill); // printing out the object in JSON form
		out.println("Mud Man is on the loose and the session is set!!!");
	}

	// this will capture parameters of an HTTP request when we send a CUSTOM villain to the session
	// by way of having the user fill out some form in the index.html
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. Extract the parameters from the request and store them to variables
		String name = request.getParameter("vill-name"); // these values must match EXACTLY with the names
		String superpower = request.getParameter("superpower"); // of the input fields in your index.html file
		double bounty = Double.parseDouble(request.getParameter("bounty")); // convert a String to a double by parsing
		
		// 2 Instantiate a SuperVillain object with those variables passed through the constructor
		SuperVillain vill = new SuperVillain(name, superpower, bounty);
		
		// 3. Grab the HTTP Session from the request
		HttpSession session = request.getSession();
		
		// 4. Set the "the-villain" name to the object by calling session.setAttribute
		session.setAttribute("the-villain", vill);
		
		// 5. Print out the the screen that we're pushed a villain to the session
		PrintWriter out = response.getWriter();
		out.println("A villain is on the loose...(in the session)");	
		
		// After it's been sent to the session, we can retrieve it by sending a GET request to 
		// the HelperSessionServlet
	}

}
