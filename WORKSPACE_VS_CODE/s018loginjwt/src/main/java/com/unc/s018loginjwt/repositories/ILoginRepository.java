package com.unc.s018loginjwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unc.s018loginjwt.entities.LoginEntity;


@Repository
public interface ILoginRepository  extends JpaRepository<LoginEntity,Long>{

    Optional<LoginEntity> findByUser(String usuario);
}
