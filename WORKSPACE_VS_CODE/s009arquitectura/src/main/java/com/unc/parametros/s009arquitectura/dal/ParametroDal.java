package com.unc.parametros.s009arquitectura.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unc.parametros.s009arquitectura.entities.ParametroEntity;
import com.unc.parametros.s009arquitectura.repositories.IParametroRepository;

@Repository
public class ParametroDal {


    @Autowired
    private IParametroRepository repo;

    public List<ParametroEntity> obtenerTodos() {
        return this.repo.findAll();
    }
    public Optional<ParametroEntity> obtenerPorId(int id){
        var op = this.repo.findById(id);
        return op;
    }

    public ParametroEntity guarda(ParametroEntity nuevo){
        var guardado = this.repo.save(nuevo);
        return guardado;
    }

    public ParametroEntity actualizar(ParametroEntity paraActualizar){

        var optGuardado = this.obtenerPorId(paraActualizar.getId());

        if(optGuardado.isPresent()){
            var guardado = optGuardado.get();
            guardado.setNombre(paraActualizar.getNombre());
            guardado.setFechaActualizacion(paraActualizar.getFechaActualizacion());
            guardado.setIdUsuarioActulizacion(paraActualizar.getIdUsuarioActulizacion());
            guardado.setValor(paraActualizar.getValor());

            return this.repo.save(guardado);

        }

        return null;
    }
    public boolean borrar(int id){
        var optGuardado = this.obtenerPorId(id);
        if(optGuardado.isPresent()){
            this.repo.delete(optGuardado.get());
            return true;
        }

        return false;

    }

}
