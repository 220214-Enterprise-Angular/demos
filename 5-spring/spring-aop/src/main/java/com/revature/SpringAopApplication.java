package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.service.Service1;
import com.revature.service.Service2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner{

	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// inject the service layers into this class so we can call them
	@Autowired
	private Service1 service1;
	
	@Autowired
	private Service2 service2;
	
	
	/**
	 * SpringApplication.run bootstraps (self-starts) the application.
	 * 
	 * .run() also creates an ApplicationContext instance and loads beans that are
	 * marked with @Component or their respective Stereotype annotation like 
	 * @Service, @Repository, @RestController.
	 * 
	 * IF you have the spring web starter dependency, then it also starts the embedded 
	 * Tomcat server by default on port 8080 (you can change that in the application.properties file)
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	
	/**
	 * Since we have implemented the CommandLineRunner interface,
	 * we'll run the following logic inside of this method INSTEAD OF launching
	 * some embedded Tomcat server and running the app there.
	 */
	@Override
	public void run(String... args) throws Exception {
		
		// log the service1's calculateSomething() method
		log.info(service1.calculateSomething());
		
		log.info(service2.calculateSomething());
	
		/**
		 * Goal: INvoke the methods on the service layer and see if our aspects intercept those
		 * method executions!
		 */
	}

}
