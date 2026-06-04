package com.wipro.APIGateway.JwtSecurity;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

        @Autowired
        private JwtUtil jwtUtil;
// This method intercepts incoming HTTP requests and checks for the presence of a JWT in the Authorization header. If a valid JWT is found, it extracts the username and role from the token and sets up the Spring Security context with the appropriate authentication details. If the token is invalid or missing, it responds with an unauthorized status.
        @Override
        protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain) 
        throws ServletException, IOException {
        String path = request.getServletPath();
        // Skip JWT validation for public endpoints
        if ("/auth/login".equals(path) || "/auth/signup".equals(path)) {
                filterChain.doFilter(request, response);
                return;
        }
        // Extract the JWT token from the Authorization header
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);
                try {
                Claims claims = jwtUtil.getClaims(token);
                String username = claims.getSubject();
                String role = claims.get("role",
                                String.class);
                if (role != null && !role.startsWith("ROLE_")) {
                        role = "ROLE_" + role;
                }
                // Set up the Spring Security context with the authenticated user's details if not already authenticated
                if (SecurityContextHolder.getContext().getAuthentication() == null) {
                        // Create an authentication token with the user's details and authorities, and set it in the security context
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                        username,
                                        null,
                                        Collections.singletonList(
                                                        new SimpleGrantedAuthority(role)));
                        authentication.setDetails(
                                        new WebAuthenticationDetailsSource()
                                                        .buildDetails(request));
                        SecurityContextHolder
                                        .getContext()
                                        .setAuthentication(authentication);
                }
                } catch (Exception e) {
                        response.setStatus(
                                        HttpServletResponse.SC_UNAUTHORIZED);
                        response.getWriter()
                                        .write("Invalid JWT Token");
                        return;
                }
        }
        filterChain.doFilter(request, response);
        }
}