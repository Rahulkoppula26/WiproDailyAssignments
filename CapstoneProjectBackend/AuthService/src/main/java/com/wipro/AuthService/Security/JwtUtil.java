package com.wipro.AuthService.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
// This method retrieves the signing key used for JWT token generation and validation. 
    private Key getSignKey() {
        String SECRET = "mysecretkeymysecretkeymysecretkey12";
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
// This method generates a JWT token for a given username and role. 

    public String generateToken(String username,String role) {
        return Jwts
                .builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }
// This method extracts the claims from a JWT token by parsing it with the signing key. 
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token) // algo. body . signin
                .getBody()
                .getSubject();
    }
// This method extracts the role claim from a JWT token by parsing its claims and retrieving the value associated with the "role" key. 
      public String extractRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }

// This method validates a JWT token by attempting to parse it with the signing key
     public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username);
    }
}
