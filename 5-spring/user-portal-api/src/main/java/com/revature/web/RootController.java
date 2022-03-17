package com.revature.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller // Remember both RestController and normal Controller are stereotype annotations
			// RestController eliminates the need for extra code (like ResponseEntity)
public class RootController {
	
	
	@GetMapping("/docs") // find all Swagger API docs at http://host:5000/api/docs
	@ResponseStatus(HttpStatus.SEE_OTHER)
	public RedirectView redirectViewToApiDocumentation() {
		return new RedirectView("swagger-ui/index.html");
	}
	
	/**
	 * This RootController is necessary along with SwaggerConfig.java
	 */

}
