package com.unc.s011productos.dal;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unc.s011productos.entities.ProductoEntity;
import com.unc.s011productos.repositories.IProductoRepository;

@Repository
public class ProductoDal {

    @Autowired
    private IProductoRepository repo;
    

    public List<ProductoEntity> obtenerTodos() throws Exception {
        return this.repo.findAll();
    }

    public Optional<ProductoEntity> obtenerPorId(int id) throws Exception {
        return this.repo.findById(id);        
    }

    public ProductoEntity guarda(ProductoEntity nuevo) {
        return this.repo.save(nuevo);        
    }

    public ProductoEntity actualizar(ProductoEntity paraActualizar) throws Exception {

        var optGuardado = this.obtenerPorId(paraActualizar.getId());

        if (optGuardado.isPresent()) {
            var guardado = optGuardado.get();
            guardado.setNombre(paraActualizar.getNombre());
            guardado.setFechaActualizacion( new Date());
            guardado.setIdUsuarioActualizacion(paraActualizar.getIdUsuarioActualizacion());
            guardado.setCosto(paraActualizar.getCosto());
            guardado.setValorVenta(paraActualizar.getValorVenta());

            return this.repo.save(guardado);

        }

        return null;
    }

    public boolean borrar(int id) throws Exception {
        var optGuardado = this.obtenerPorId(id);
        if (optGuardado.isPresent()) {
            this.repo.delete(optGuardado.get());
            return true;
        }
        return false;
    }
}
