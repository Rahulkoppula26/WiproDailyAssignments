package com.wipro.APIGateway.JwtSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class JwtConfig {

  @Autowired
  private JwtFilter jwtFilter;

  public JwtConfig(JwtFilter jwtFilter) {
    this.jwtFilter = jwtFilter;
  }
// This method configures the security filter chain for the application. It disables CSRF protection, enables CORS using the CorsConfig bean, and sets up authorization rules for various endpoints. It also adds the JwtFilter to the filter chain to handle JWT authentication.
  @Bean
  public SecurityFilterChain securityFilterChain(
      HttpSecurity http) throws Exception {

    return http
        .csrf(csrf -> csrf.disable())
        // Use the CorsConfig bean so CORS headers are set only once
        .cors(cors -> {
        })

        .authorizeHttpRequests(auth -> auth

    .requestMatchers(
        "/auth/login",
        "/auth/signup",
        "/auth/**",
        "/swagger-ui.html",
        "/swagger-ui/**",
        "/v3/api-docs/**",
        "/auth/v3/api-docs/**",
        "/admin/v3/api-docs",
        "/users/v3/api-docs",
        "/notifications/v3/api-docs"
    )
    .permitAll()
// Authorization rules for different endpoints based on user roles. Admins can access all admin endpoints, while both users and admins can access user-related endpoints and notifications.
    .requestMatchers(HttpMethod.GET, "/admin/songs/**")
    .hasAnyRole("ADMIN", "USER")

    .requestMatchers("/admin/users/**")
    .hasRole("ADMIN")

    .requestMatchers(HttpMethod.GET, "/users/songs/**")
    .hasAnyRole("USER", "ADMIN")

    .requestMatchers("/users/playlists/**")
    .hasAnyRole("USER", "ADMIN")

    .requestMatchers("/notifications/**").hasAnyRole("USER", "ADMIN")
    
    .anyRequest()
    .authenticated()
)
// Add the JwtFilter before the UsernamePasswordAuthenticationFilter in the filter chain

        .addFilterBefore(
            jwtFilter,
            UsernamePasswordAuthenticationFilter.class)

        .build();
  }
}