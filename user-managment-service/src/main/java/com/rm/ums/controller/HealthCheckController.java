package com.rm.ums.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/")
public class HealthCheckController {

	@GetMapping("/")
	public String hello() {
		return "User management service is up and running!";
	}

}
