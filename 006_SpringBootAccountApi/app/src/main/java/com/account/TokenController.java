package com.account;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Date;
import java.time.Duration;
import java.time.Instant;

@RestController
public class TokenController {
    @PostMapping("/token")
    public String token(@RequestBody UserPassword userPassword) throws Exception {
        if (userPassword.getUser().equals("testuser1") && userPassword.getPassword().equals("Password123")) {
            Key key = getKey();
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

    private Key getKey() throws Exception {
        byte[] keyBytes = TokenController.class.getResourceAsStream("/private_key.der").readAllBytes();
        PKCS8EncodedKeySpec keySpec =
                new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    @GetMapping("/token/verify")
    public String verify(@RequestHeader HttpHeaders headers) throws Exception {
        String authorization = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if (authorization.startsWith("Bearer")) {
            String jws = authorization.substring("Bearer".length());
            Key key = getPublicKey();
            boolean valid = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jws)
                    .getBody()
                    .getSubject()
                    .equals("account");
            return valid ? "JWT is valid" : "JWT is not valid";
        } else {
            return ResponseEntity.badRequest().toString();
        }
    }

    private Key getPublicKey() throws Exception {
        byte[] keyBytes = TokenController.class.getResourceAsStream("/public_key.der").readAllBytes();
        X509EncodedKeySpec keySpec =
                new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}
