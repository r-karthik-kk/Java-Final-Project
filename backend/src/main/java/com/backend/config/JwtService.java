package com.backend.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    private final JwtProperties properties;

    public JwtService(JwtProperties properties) {
        this.properties = properties;
    }

    private Key getSigningKey() {

        return Keys.hmacShaKeyFor(
                properties.getSecret()
                        .getBytes(StandardCharsets.UTF_8)
        );

    }

    public String generateToken(

            String username,

            String role,

            Map<String, Object> claims

    ) {

        return Jwts.builder()

                .claims(claims)

                .subject(username)

                .claim("role", role)

                .issuedAt(new Date())

                .expiration(

                        new Date(

                                System.currentTimeMillis()
                                        + properties.getExpiration()

                        )

                )

                .signWith(getSigningKey())

                .compact();

    }

    public Claims extractClaims(String token) {

        return Jwts.parser()

                .verifyWith((javax.crypto.SecretKey) getSigningKey())

                .build()

                .parseSignedClaims(token)

                .getPayload();

    }

    public String extractUsername(String token) {

        return extractClaims(token).getSubject();

    }

}