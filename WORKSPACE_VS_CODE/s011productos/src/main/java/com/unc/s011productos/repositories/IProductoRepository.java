package com.unc.s011productos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unc.s011productos.entities.ProductoEntity;

public interface IProductoRepository extends JpaRepository<ProductoEntity,Integer>{

}
