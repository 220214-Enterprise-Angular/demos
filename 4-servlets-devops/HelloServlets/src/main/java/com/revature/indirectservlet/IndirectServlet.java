package com.revature.indirectservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndirectServlet extends HttpServlet {
	
	
    // IF this servlet recieves a GET request, re-direct it to our DirectServlet at /dirserv
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// we are redirecting the reponsibility of handling the HTTP Request and delivering a response to another resource
		response.sendRedirect("http://localhost:8080/HelloServlets/dirserv"); // instead the DirectServlet will return a response
		
		// When you use sendRedirect, a new request is created and the URL is rewritten
//		response.sendRedirect("https://google.com");
			
		System.out.println("Triggered the doGet() method within IndirectServlet and redirected to DirectServlet");		
		
System.out.println("Context Example: " + getServletContext().getInitParameter("contextExample"));
		
		// call the servlet config - we have not SET a config for this servlet
		System.out.println("Config Example: " + getServletConfig().getInitParameter("configExample"));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// another way of facilitating inter-servlet communication: forward() method from the RequestDispatcher
		RequestDispatcher rdis = request.getRequestDispatcher("/dirserv");
		
		rdis.forward(request, response); // the DirectServlet becomes responsible for handling the
										 // forwarded request and delivering a response.
		System.out.println("doPost() method triggered in IndirectServlet");
		
	
	}

	/*
	 * Here is a list of major differences between servlet forward and
	 * sendRedirect()
	 * 
	 * sendRedirect():
	 * 
	 * The request is redirected to a different resource The client will see the URL
	 * change after the redirect A totally new request is created Redirect is
	 * normally used within Post/Redirect/Get web development pattern
	 *
	 * 
	 * forward():
	 * 
	 * The request will be further processed on the server side. The client isn't
	 * impacted by forward, 
	 * 
	 * - URL in a browser stays the same (doesn't change based on the resource that you forwarded to) 
	 * - Request and response objects will remain the same object after forwarding. 
	 * - Request-scope objects
	 * will be still available
	 */
	
	
	
	
	
}
