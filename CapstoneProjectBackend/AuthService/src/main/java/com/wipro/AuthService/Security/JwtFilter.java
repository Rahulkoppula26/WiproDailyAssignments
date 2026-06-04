package com.wipro.AuthService.Security;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wipro.AuthService.Entity.User;
import com.wipro.AuthService.Repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserRepository userRepo;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();

        return path.equals("/auth/login")
                || path.equals("/auth/signup");
    }

    // internally called by jwt filter
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            token = authHeader.substring(7);
            // 01234567
            // Authorization -> Bearer
            // eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJOZWhhIiwiaWF0IjoxNzc4OTk5MzExLCJleHAiOjE3NzkwMDI5MTF9.yhWdqzVPwXTK8WMyLEogNK2N2E3jAyokffjYEC0px38
            username = jwtUtil.extractUsername(token); // extract username from token
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            Optional<User> user = userRepo.findByUsername(username);

            if (user.isPresent() && jwtUtil.validateToken(token, user.get().getUsername())) {
                String role = jwtUtil.extractRole(token);
                // we have used a new method simple granted authority
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
                        null, List.of(new SimpleGrantedAuthority(role)));

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
