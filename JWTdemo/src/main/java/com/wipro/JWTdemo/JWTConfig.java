package com.wipro.JWTdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


//Step-6
@Configuration
public class JWTConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//step-18
	@Autowired
	JwtFilter jwtFilter;
	
	//step-14
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	      return  http
	            .csrf(csrf -> csrf.disable())
	            // VERY IMPORTANT FOR CORS
	            .cors(cors -> {})

	            .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/signup","/login").permitAll()
	            .anyRequest().authenticated())
	            //step-19
	            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // add your own jwt filter
	            .build();
	    }
	 
//	 @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//	      return  http
//	            .csrf(csrf -> csrf.disable())
//	            .authorizeHttpRequests(auth -> auth
//	            .requestMatchers("/signup","/login").permitAll()
//	            .anyRequest().authenticated())
//	            .build();
//	    }
}
