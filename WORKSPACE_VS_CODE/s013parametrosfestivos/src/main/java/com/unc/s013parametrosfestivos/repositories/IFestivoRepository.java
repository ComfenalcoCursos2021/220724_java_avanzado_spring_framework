package com.unc.s013parametrosfestivos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unc.s013parametrosfestivos.entities.FestivoEntity;

public interface IFestivoRepository extends JpaRepository<FestivoEntity,Integer>{

}
