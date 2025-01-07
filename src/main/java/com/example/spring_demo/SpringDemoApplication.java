package com.example.spring_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// adding packages outside the main one
/*
@SpringBootApplication(
		scanBasePackages = {"package_name_1",
							"package_name_2"})
 */
@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {

//		// Print environment variables to verify they are loaded
//		System.out.println("DB_URL: " + System.getenv("DB_URL"));
//		System.out.println("DB_USERNAME: " + System.getenv("DB_USERNAME"));

		SpringApplication.run(SpringDemoApplication.class, args);
	}
}
