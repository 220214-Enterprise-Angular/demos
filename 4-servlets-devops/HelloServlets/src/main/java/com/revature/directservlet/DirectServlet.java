package com.revature.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

/**
 * This class is a Servlet class.
 * This class extends server side capabilities of a java program.
 * ...meaning, we can accepts an HTTP request, and deliver a response directly to the client.
 *
 * HttpServelt extends GenericServlet which implements the Servlet interface
 */
public class DirectServlet extends HttpServlet { // this comes from the Servlet API 

	// we need a method to handle a GET request at /dirserv
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		// here we formulate the response for this program to send back in an http response
		// when this Servlet is hit with a GET request from a client
		
		response.setContentType("text/html"); // setting the content to be delivered to the client
		
		// PrintWriter can be obtained from the response object and we can print text data to a character stream
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>The Servlet is talking directly the client!</h1></body></html>");
		
		// we'll see the above html written directly onto a blank page when we hit this servlet class
		// with a GET request
		
		// We need to map this servlet class to a specific end point http://localhost:8080/HelloServlets/dirserv
		// By setting up the servlet mapping in the web.xml file
	}
	
	
	// Here I'm giving this servlet the ability to handle a post request
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		// ideally a JSON object would be posted aka sent to this servlet and maybe we could transform it to a Java
		// object, then store it in a database.
		// question becomes: how do we transform a JSON object into a java object of a class that we have defined?
		// we need an object mapper 
		
		// Step 1. Set response type as JSON
		response.setContentType("application/json");
		
		// Step 2. Instantiate a SuperVillain Object
		SuperVillain vill = new SuperVillain("The Penguin", "money", 9000.10); // ctrl + shift + o
		
		// Step 3. Transform the Java villain object to JSON AND write it to the client with the print writer
		PrintWriter out = response.getWriter(); // grabbing the object that allows me to send data to a client
		
		// transofmr the villain object from java to a JSON string 
		// we are instantiating the Object Mapper object from the Jackson Object Mapping library
		String jsonString = new ObjectMapper().writeValueAsString(vill); // returns a JSON string
		
		// grab our print writer whose job is to write info to be displayed in the browser
		out.write(jsonString); 
	}
	
	
	
	
	
	
	
	
	
}
