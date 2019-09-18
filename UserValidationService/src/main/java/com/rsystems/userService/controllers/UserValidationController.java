package com.rsystems.userService.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserValidationController {
	
	
	
	@GetMapping(path = "/validate/{token}")
	public boolean validate(@PathVariable String token) {

		if("validuser".equalsIgnoreCase(token)) {
			return true;
		}else {
			return false;
		}
	}

}
