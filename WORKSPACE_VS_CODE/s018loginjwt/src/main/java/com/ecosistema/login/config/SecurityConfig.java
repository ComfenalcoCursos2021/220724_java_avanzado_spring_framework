package com.ecosistema.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	@Bean 
	AuthenticationManager authManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).build();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, 
			AuthenticationManager authManager) throws Exception {
		return http.csrf().disable()
				.authorizeHttpRequests()
				.anyRequest()
				.permitAll()
				.and()
				.build();
	}
	
	@Bean
	public PasswordEncoder myPassEncoder() {
		return new BCryptPasswordEncoder();
	}	
}
