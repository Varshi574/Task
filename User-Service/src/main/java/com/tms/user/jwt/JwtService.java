package com.tms.user.jwt;

import java.sql.Date;
import java.util.Base64;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService 
{
	private static final String SECRET = "02B0046014E0EC64FDF97354E131195C2721484B682B8304D261C70923DF64F2E4BB818BCF230884C2462B650BE94FF853B728AEF6C74BC49669263F1293A031";
	private static final long expiration = 1000 * 60 * 60 * 10;

	public String generateToken(UserDetails userDetails) {
		System.out.println(userDetails.getUsername());
		return Jwts.builder().subject(userDetails.getUsername()).issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + expiration)).signWith(generateKey()).compact();

	}

	private SecretKey generateKey() {
		byte[] decodeKey = Base64.getDecoder().decode(SECRET);
		return Keys.hmacShaKeyFor(decodeKey);
	}
	
	public String extractUsername(String jwt) {
		Claims claims = getClaims(jwt);
		System.out.println(claims.getSubject());
		return claims.getSubject();
	}

	private Claims getClaims(String jwt) {
		return Jwts.parser().verifyWith(generateKey()).build().parseSignedClaims(jwt).getPayload();
	}

	public boolean isTokenValid(String jwt) {
		Claims claims = getClaims(jwt);
		boolean valid = claims.getExpiration().after(new Date(System.currentTimeMillis()));
		System.out.println(valid);
		return  valid;
	}
	
}
