package com.example.springcloudsleuth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	
	private static final Logger logger=LoggerFactory.getLogger(TestController.class);
	@Autowired
	private RestTemplate restTemplate;
		
	@GetMapping("/service1")
	public String service1() {
		logger.info("service1 called ....");
		return "service1...";
	}
	
	@GetMapping("/service2")
	public String service2() {
		logger.info("service2 called ....");
		return restTemplate.getForObject("http://localhost:8080/service1", String.class);
	}

}
