package com.wipro.DIDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myconfig {
	
	
	  @Bean
	  public Address address()
	  {
		  Address obj = new Address();
		  obj.setCity("karimnagar");
		  return obj;
	  }
	  
	  
	  @Bean
	  public Student student()
	  {
		  return new Student(123,"rahul",address());  
	  }
	

}