package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class UserPortalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserPortalApiApplication.class, args);
	}
	
	// Set the default welcome view to the index.html page (inside the static folder)
	@RequestMapping("/")
	public ModelAndView home()
	{
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index"); // our index.html page will be rendered at http://localhost:5000/api 
	    return modelAndView;			   // we'll see index.html
	}
	

}
