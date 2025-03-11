package com.i2i.userandrole.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.List;

@Component
public class JwtUtil {


    private final Key secretKey;

    public JwtUtil(@Value("${app.secret-key}") String key) {
        this.secretKey = Keys.hmacShaKeyFor(key.getBytes());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String extractUsername(String token) {
        var claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public List<String> extractRoles(String token) {
        var claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
        return claims.get("roles", List.class);
    }

    public String generateToken(String username,List<String> roles) {
        return Jwts.builder().signWith(secretKey).setSubject(username).claim("roles",roles).compact();
    }
}
