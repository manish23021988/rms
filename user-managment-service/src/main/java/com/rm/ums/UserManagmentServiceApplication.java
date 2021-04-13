package com.rm.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.rm.ums")
public class UserManagmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagmentServiceApplication.class, args);
	}
}