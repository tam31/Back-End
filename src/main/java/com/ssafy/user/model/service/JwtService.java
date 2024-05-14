package com.ssafy.user.model.service;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ssafy.user.model.dto.MemberDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
	private String secretKey = "myKey";
	private long exp = 1000L * 60 * 60; // 토큰 사용가능 시간, 1시간
	
	
	public String createToken(MemberDTO member) {
		return Jwts.builder()
				.setHeaderParam("typ", "JWT")
				.setSubject("userToken")
				.setExpiration(new Date(System.currentTimeMillis() + exp)) // 토큰 유효시간
				.claim("user", member) //토큰에 담을 데이터
				.signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
				.compact();
	}
	
	public Map<String, Object> getInfo(String token) throws Exception {
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token); // secretKey를 사용하여 복호화
		}catch(Exception e) {
			throw new Exception();
		}
		return claims.getBody();
	}
	
	
	// interceptor에서 토큰 유효성을 검증하기 위한 메서드
	public void checkValid(String token) {
		Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token);
	}
}
