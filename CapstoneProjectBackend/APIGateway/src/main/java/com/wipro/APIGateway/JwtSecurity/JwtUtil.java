package com.wipro.APIGateway.JwtSecurity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    private static final String SECRET =
            "mysecretkeymysecretkeymysecretkey12";

// This method generates a signing key for JWTs using the secret key defined in the class. It uses the HMAC SHA algorithm to create a secure key for signing and verifying JWTs.
    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public Claims getClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
//   This method extracts the username (subject) from a JWT token by parsing its claims. It uses the getClaims method to retrieve the claims and then returns the subject, which is typically the username of the authenticated user.
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return getClaims(token)
                .get("role", String.class);
    }
// This method validates a JWT token by attempting to parse its claims. If the token is valid, it returns true; if any exception occurs during parsing (indicating an invalid token), it returns false.
    public boolean validateToken(String token) {

        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}