package com.ecosistema.login.config;

import java.nio.CharBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecosistema.login.dto.LoginDto;
import com.ecosistema.login.repositories.ILoginRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static String SECRET_KEY = "jJG98CN5j5M5%zLG*SR*I2Kfbrl1yBdN";
	
	@Autowired
	private ILoginRepository loginRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ModelMapper mapper;
	
	public LoginDto loggeo(LoginDto loginDto) throws Exception {
		
		var user = loginRepository.findByUser(loginDto.getUser())
				.orElseThrow(()-> new Exception("El usuario no existe"));
		
		if(passwordEncoder.matches(CharBuffer.wrap(loginDto.getPassword()), user.getPassword())) {
			loginDto.setToken(createToken(loginDto));
			return loginDto;
		}
		
		throw new Exception("Password invalida");
		
	}
	public LoginDto validateToken(String token) throws Exception {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(SECRET_KEY.getBytes())
				.build()
				.parseClaimsJws(token)
				.getBody();
		String user = claims.getSubject(); 
		
		var loginEntity = loginRepository.findByUser(user)
				.orElseThrow(()-> new Exception("El usuario no existe"));
		
		var loginDto = mapper.map(loginEntity,LoginDto.class);
		loginDto.setToken(token);
		return loginDto;
	}
	
	
	private String createToken(LoginDto login) {
		long expirationTime = 1000 * 60*60*24;
		
		Date expDate = new Date(System.currentTimeMillis()+expirationTime);
		
		Map<String,Object> extraData = new HashMap<String,Object>();
		
		extraData.put("nombre", login.getUser());
		extraData.put("WholeUser", login);
		
		return Jwts.builder()
				.setSubject(login.getUser())
				.setExpiration(expDate)
				.addClaims(extraData)
				.signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
				.compact();
	}
}
