package com.ecosistema.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecosistema.login.bl.LoginBl;
import com.ecosistema.login.dto.LoginDto;
import com.ecosistema.login.globaldto.ResultadoDto;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginBl loginBl;
	
	
	@GetMapping
	public ResultadoDto<List<LoginDto>> findAll(){
		return this.loginBl.findAll();
	}
	@GetMapping("/{id}")
	public ResultadoDto<LoginDto> findById(@PathVariable long id){
		return this.loginBl.findById(id);
	}
	
	
	@PostMapping("/loggeo")
	public LoginDto loggeo(@RequestBody LoginDto login) throws Exception{
		return this.loginBl.loggeo(login);
	}
	
	@PostMapping("/validateToken")
	public LoginDto loggeo(@RequestParam String token) throws Exception{
		return this.loginBl.validateToken(token);
	}
	
	
	
	@PostMapping
	public ResultadoDto<LoginDto> save(@RequestBody LoginDto login){
		return this.loginBl.save(login);
	}
	@PutMapping
	public ResultadoDto<LoginDto> update(@RequestBody LoginDto login){
		return this.loginBl.update(login);
	}
	
	@DeleteMapping("/{id}")
	public ResultadoDto<String> delete(@PathVariable long id){
		return this.loginBl.delete(id);
		
	}
}
