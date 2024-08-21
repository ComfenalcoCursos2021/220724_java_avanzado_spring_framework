package com.ecosistema.login.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecosistema.login.entity.LoginEntity;

@Repository
public interface ILoginRepository  extends JpaRepository <LoginEntity,Long>{

	Optional<LoginEntity> findByUser(String usuario);
	Optional<LoginEntity> findByUserAndPassword(String usuario,String password);
}
