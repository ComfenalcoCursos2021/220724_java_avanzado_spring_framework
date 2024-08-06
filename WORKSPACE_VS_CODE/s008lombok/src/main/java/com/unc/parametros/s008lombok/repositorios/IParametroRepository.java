package com.unc.parametros.s008lombok.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unc.parametros.s008lombok.entidades.ParametroEntity;

public interface IParametroRepository  extends JpaRepository<ParametroEntity,Integer>{

    
} 