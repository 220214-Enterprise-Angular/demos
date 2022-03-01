package com.revature;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class App {
	
	// capture the path to the resource
	private static final String INPUT_FILE = "C:\\Users\\SophieGavrila\\Desktop\\demos\\3-javaSE-apis\\ThrouputHttpServer\\src\\main\\resources\\war_and_peace.txt";
	
	
	public static void main(String[] args) throws IOException {
		
		// Save the entier content of the file to a String object
		String text = "";
		
		try {
			text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
		} catch (IOException e) {
			System.out.println("Couldn't locate file"); // better to be logged with Log4J
			e.printStackTrace();
		}
		
		// pass the resource to a method called startServer() and invoke it
		startServer(text);
	}
	
	// responsible to starting the web server an setting up the context of the web server
	public static void startServer(String text) throws IOException {
		
		// defines where a functionality is available and what to do at that end point
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		
		/**
		 * Create a context which assigns a handler object to a specific http
		 * route. This handler handles each incoming http request and sends a response.
		 * client can send requests to http://localhost:8000/search -> trigger a method inside of our application
		 */
		server.createContext("/search", new WordCountHandler(text));
		
		// set up an executor service to schedule a thread to handle evey incoming HTTP request
		Executor executor = Executors.newFixedThreadPool(2);
		
		server.setExecutor(executor);
		
		server.start();
	}
	
	public static class WordCountHandler implements HttpHandler {
		
		private String text;
		
		public WordCountHandler(String text) {
			this.text = text;
		}
		
    	/*
		 * What is HttpExchange param?
		 * 
		 * This class encapsulates a HTTP request received and a response to be
		 * generated in one exchange. 
		 * 
		 * It provides methods for examining the request from
		 * the client, and for building and sending the response.
		 */
		@Override // comes from HttpHandler
		public void handle(HttpExchange httpExchange) throws IOException {
			// we can capture the HTTP request info and extract query parameters
			
			String query = httpExchange.getRequestURI().getQuery();
			// the above method will return word=talk from the request: http://localhost:8000/search?word=talk
			
			String[] keyValuePair = query.split("="); // [word, talk]
			String action = keyValuePair[0]; // extract the first element
			// check that the first element is word
			String word = keyValuePair[1]; // capture the second part of the key value pair which is the word we're serachign for
			
			if (!action.equals("word")) {
				
				httpExchange.sendResponseHeaders(400, 0); // send back a 400 error meaning the client made a mistake
				return;
			}
			
			String count = countWord(word);
			
			// generate an HTTP response
			// first convert it to a byte array 
			byte[] response = count.getBytes(); // transforms String into a byte array
			// setup the HTTP response
			httpExchange.sendResponseHeaders(201, response.length);
			
			// transform it into an Output STream
			OutputStream outputStream = httpExchange.getResponseBody();
			
			// write the response into the output stream
			outputStream.write(response);
			
			// close the stream
			outputStream.close();	
		}
		
		// returns a phrase that says "this word appeared x times"
		private String countWord(String word) {
			
			System.out.println("countWord() method triggered");
			
			int count = 0; // increase the count every time we find the word
			int index = 0; // measure where we leave off
			
			// run a loop that will check for every appearance of a word passed through
			while (index >= 0) {
				
				// reset the index to the end of where we found the word
				index = text.indexOf(word, index);
				
				if (index >= 0) {
					count ++; // we found the word
					index++; // move forward
				}
				
			}
			return "The word " + word + " appeared " + count + " times.";
			// we will return the returned value of this method within the body of an HTTP response
		}

	}
	
	

}
