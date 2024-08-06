package com.unc.parametros.s009arquitectura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unc.parametros.s009arquitectura.entities.ParametroEntity;

public interface IParametroRepository extends JpaRepository<ParametroEntity,Integer>{

}
