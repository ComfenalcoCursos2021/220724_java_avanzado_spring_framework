package com.unc.arq.s010arquitenctura2.dal;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unc.arq.s010arquitenctura2.entities.ParametroEntity;
import com.unc.arq.s010arquitenctura2.repositories.IParametroRepository;

@Repository
public class ParametroDal {

    @Autowired
    private IParametroRepository repo;
    Random a = new Random();

    public List<ParametroEntity> obtenerTodos() throws Exception {
        if (a.nextInt(100) < 50) 
            throw new Exception("falla inesperada e incontrolada");
        

        return this.repo.findAll();

    }

    public Optional<ParametroEntity> obtenerPorId(int id) throws Exception {

        if (a.nextInt(100) < 50) 
            throw new Exception("falla inesperada e incontrolada");
            
        var op = this.repo.findById(id);
        return op;
    }

    public ParametroEntity guarda(ParametroEntity nuevo) {
        var guardado = this.repo.save(nuevo);
        return guardado;
    }

    public ParametroEntity actualizar(ParametroEntity paraActualizar) throws Exception {

        var optGuardado = this.obtenerPorId(paraActualizar.getId());

        if (optGuardado.isPresent()) {
            var guardado = optGuardado.get();
            guardado.setNombre(paraActualizar.getNombre());
            guardado.setFechaActualizacion(paraActualizar.getFechaActualizacion());
            guardado.setIdUsuarioActualizacion(paraActualizar.getIdUsuarioActualizacion());
            guardado.setValor(paraActualizar.getValor());

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
