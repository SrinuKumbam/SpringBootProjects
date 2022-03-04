package com.gateway.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public class FallBackController {

	@GetMapping("/userServiceFallBack")
	public String userServiceFallbackMethod() {
		return "User Service taking longer than expected"+
				"Please try again";
	}
	
	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallbackMethod() {
		return "Department Service taking longer than expected"+
				"Please try again";
	}
}
