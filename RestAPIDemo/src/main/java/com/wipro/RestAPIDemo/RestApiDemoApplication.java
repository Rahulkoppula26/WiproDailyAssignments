package com.wipro.RestAPIDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Annotation for declaring this project as a spring boot 
@SpringBootApplication
public class RestApiDemoApplication {

	public static void main(String[] args) {
		
//		this static run method , runs the entire main method and starts the tomcat and spring internally
		SpringApplication.run(RestApiDemoApplication.class, args);
	}

}
