package com.revature.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is a Servlet class.
 * This class extends server side capabilities of a java program.
 * ...meaning, we can accepts an HTTP request, and deliver a response directly to the client.
 *
 * HttpServelt extends GenericServlet which implements the Servlet interface
 */
public class DirectServlet extends HttpServlet { // this comes from the Servlet API 

	// we need a method to handle a GET request
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
		
	}
	
	
}
