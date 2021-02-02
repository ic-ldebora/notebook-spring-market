package com.market.backend.web.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

  // An expiration time of 10 hours as a sample.
  private static final int EXPIRATION_TIME = 1000 * (60 * 60 * 10);

  // A sample key.
  private static final String KEY = "market";

  public String genenrateToken(UserDetails userDetails) {
    return Jwts.builder()
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(SignatureAlgorithm.HS256, KEY)
        .compact();
  }
}
