package com.unc.s013parametrosfestivos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unc.s013parametrosfestivos.entities.ParametroEntity;

public interface IParametroRepository extends JpaRepository<ParametroEntity,Integer>{

}
