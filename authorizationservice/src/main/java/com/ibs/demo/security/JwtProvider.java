package com.ibs.demo.security;

import java.security.Key;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@Service
public class JwtProvider {
	private Key key;

	@PostConstruct
	public void init() {
		key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//		System.out.println("Key = "+key);

	}

	public String generateToken(Authentication authentication) {
		User principal = (User) authentication.getPrincipal();
		return Jwts.builder().setSubject(principal.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
				.claim("id", "ibs_key_security_0105").signWith(key).compact();
	}

	public boolean validateToken(String jwt) {
		try {
			Jwts.parser().setSigningKey(key).parseClaimsJws(jwt);
			return true;
		}

		catch (ExpiredJwtException e) {
			log.error("JWT token is expired: {}", e.getMessage());
		}
		return false;
	}

	public String getUsernameFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();

		return claims.getSubject();
	}
}
