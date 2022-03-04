package com.boot.training.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	private String apiKey;
	
	@GetMapping("/")
	public String index() {
		return "Welcome to Springboot "+apiKey;
	}
}
