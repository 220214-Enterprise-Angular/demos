package com.revature;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class App {
	
	public static void main(String[] args) {
		
		// capture the path to the resource
		
		// pass the resource to a method called startServer()
		
		// invoke startServer();
		
	}
	
	// responsible to starting the web server an setting up the context of the web server
	public static void startServer(String text) {
		
		// defines where a functionality is available and what to do at that end point
		
		
	}
	
	public static class WordCountHandler implements HttpHandler {

		@Override // comes from HttpHandler
		public void handle(HttpExchange httpExchange) throws IOException {
			// we can capture the HTTP request info and extract query parameters
			
		}

	}
	
	// reutrns a phrase that says "this word appeared x times"
	public String countWord(String word) {
		
		return null;
	}

}
