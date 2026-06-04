package com.wipro.JWTdemo;

import io.jsonwebtoken.*;

import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;

//step-10

@Component
public class JwtUtil {

	private final String SECRET = "mysecretkeymysecretkeymysecretkey12";

	private Key getSignKey() {
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
				.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	}

//	step-15
	public boolean validateToken(String token, String username) {
		final String extractedUsername = extractUsername(token);
		return extractedUsername.equals(username);
	}
// step-16
	public String extractUsername(String token) {

		return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token) // algo. body . signin
				.getBody().getSubject();
	}

}
