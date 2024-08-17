package com.unc.s018loginjwt.services;

import java.nio.CharBuffer;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.unc.s018loginjwt.dtos.LoginDto;
import com.unc.s018loginjwt.entities.LoginEntity;
import com.unc.s018loginjwt.repositories.ILoginRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtService {

    private static String SECRET_KEY = "";

    @Autowired
    private ILoginRepository repo;

    @Autowired 
    private PasswordEncoder cifradorInyectado;

    @Autowired
    private ModelMapper mapper;



    public LoginDto loggeo(LoginDto loginDto) throws Exception {

        var user = this.repo.findByUser(loginDto.getUser()).orElseThrow(() -> new Exception("EL USUARIO NO EXISTE"));
        if(this.cifradorInyectado.matches(CharBuffer.wrap(loginDto.getPassword()),user.getPassword())){
            loginDto.setToken(this.createToken(loginDto));
            return loginDto;
        }
        throw new Exception("PASSWORD INVALIDA");

    }


    
    private String createToken(LoginDto login){
        long expirationTime = 1000*60*60*24;
        Date expDate = new Date(System.currentTimeMillis() + expirationTime);
        Map<String,Object> extraData = new HashMap<String,Object>();

        extraData.put("Nombre", login.getUser());
        extraData.put("ElObjeto", login);

        return Jwts.builder()
                .subject(login.getUser())
                .expiration(expDate)
                .claims(extraData)
                .signWith(Keys.hmacShaKeyFor(this.SECRET_KEY.getBytes()))
                .compact();


    }

    public LoginDto validateToken(String token) throws Exception{
        Claims claims = Jwts.parser()
        .verifyWith(Keys.hmacShaKeyFor(this.SECRET_KEY.getBytes()))
        .build()
        .parseSignedClaims(token)
        .getPayload();

        String user = claims.getSubject();
        LoginEntity loginEntity = this.repo.findByUser(user).orElseThrow(() -> new Exception("EL USUARIO NO EXISTE"));

        var loginDto = this.mapper.map(loginEntity, LoginDto.class);
        loginDto.setToken(token);
        return loginDto;
    }
}
