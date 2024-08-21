package com.ecosistema.login.bl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.ecosistema.login.config.JwtService;
import com.ecosistema.login.dal.LoginDal;
import com.ecosistema.login.dto.LoginDto;
import com.ecosistema.login.entity.LoginEntity;
import com.ecosistema.login.globaldto.ResultadoDto;
import com.google.common.reflect.TypeToken;

@Service
public class LoginBl {

	
	@Autowired
	private LoginDal loginDal;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private JwtService jwtService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public ResultadoDto<List<LoginDto>> findAll(){
		try {
			var result = this.loginDal.findAll();
			List<LoginDto> todosLosDatos = mapper.map(result, 
					new TypeToken<List<LoginDto>>() {
			}.getType());			
			
			return ResultadoDto.<List<LoginDto>>ok(todosLosDatos);
			
		} catch (Exception e) {			
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<LoginDto> findById(long id){
		try {
			var result = this.loginDal.findById(id);
			var resultado =  mapper.map(result, LoginDto.class);			
			
			return ResultadoDto.<LoginDto>ok(resultado);
			
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
				
	}
	public LoginDto loggeo(LoginDto login) throws Exception {
		return jwtService.loggeo(login);
	}
	
	public LoginDto validateToken(String token) throws Exception {
		return jwtService.validateToken(token);
	}
	
	public ResultadoDto<LoginDto> save(LoginDto newLogin) {
		
		try {
			var entity = mapper.map(newLogin, LoginEntity.class);
			entity.setId(0L);
			entity.setPassword(passwordEncoder.encode(entity.getPassword()));
			entity = this.loginDal.save(entity);
			return ResultadoDto.ok(mapper.map(entity, LoginDto.class));	
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	public ResultadoDto<LoginDto> update(LoginDto login) {
		try {
			var entity = mapper.map(login, LoginEntity.class);		
			entity = this.loginDal.update(entity);
			return ResultadoDto.ok( mapper.map(entity, LoginDto.class));
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
	public ResultadoDto<String> delete(long id) {
		try {
			this.loginDal.delete(id);
			return ResultadoDto.ok(null);
		} catch (Exception e) {
			return ResultadoDto.Falla(e);
		}
		
	}
	
}
