package com.example.taskapi.util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;
import io.jsonwebtoken.Claims;
@Component
public class JwtUtil {
    private final String SECRET_KEY="mysecretkeymysecretkeymysecretkeymysecretkey";
    public String generateToken(String username,String role){
        return Jwts.builder()
                .setSubject(username)
                .claim("role",role)//stores role inside token
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }
    public String extractUsername(String token){
        return extractClaims(token).getSubject();
    }
    public String extractRole(String token){
        return extractClaims(token).get("role",String.class);
    }

    private Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token).getBody();
    }
}
