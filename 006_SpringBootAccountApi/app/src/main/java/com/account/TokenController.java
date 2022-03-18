package com.account;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.sql.Date;
import java.time.Duration;
import java.time.Instant;

@RestController
public class TokenController {
    @PostMapping("/token")
    public String token(@RequestBody UserPassword userPassword) {
        if (userPassword.getUser().equals("testuser1") && userPassword.getPassword().equals("Password123")) {
            Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
            String jwt = Jwts.builder()
                    .setIssuer("Account")
                    .setSubject("account")
                    .claim("name", "User1")
                    .claim("scope", "admins")
                    .setIssuedAt(Date.from(Instant.now()))
                    .setExpiration(Date.from(Instant.now().plus(Duration.ofDays(1))))
                    .signWith(key)
                    .compact();
            return jwt;
        } else {
            return ResponseEntity.badRequest().toString();
        }
    }
}
