package com.ecosistema.login.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosistema.login.entity.LoginEntity;
import com.ecosistema.login.repositories.ILoginRepository;

@Service
public class LoginDal {
	@Autowired
	private ILoginRepository loginRepository;

	public List<LoginEntity> findAll() {
		return this.loginRepository.findAll();
	}

	public LoginEntity findById(long id) {
		return this.loginRepository.findById(id).get();
	}

	public LoginEntity save(LoginEntity entity) {
		return this.loginRepository.save(entity);
	}

	public LoginEntity update(LoginEntity entity)  {		
		 
		return this.loginRepository.findById(entity.getId())
				.map( x -> {					
					x.setPassword(entity.getPassword());
					x.setUser(entity.getUser());					
					return this.loginRepository.save(x);
				}).get();
	}
	
	public void delete(long id) throws Exception {
		
		if(!this.loginRepository.existsById(id)) {
			throw new Exception("El id ingresado no existe");
		}
		this.loginRepository.deleteById(id);
	}
}
