package com.unc.s013parametrosfestivos.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unc.s013parametrosfestivos.entities.ParametroEntity;
import com.unc.s013parametrosfestivos.repositories.IParametroRepository;

@Repository
public class ParametroDal {

    @Autowired
    private IParametroRepository repo;
    

    public List<ParametroEntity> obtenerTodos() throws Exception {
        return this.repo.findAll();
    }

    public Optional<ParametroEntity> obtenerPorId(int id) throws Exception {
        return this.repo.findById(id);        
    }

    public ParametroEntity guarda(ParametroEntity nuevo) {
        return this.repo.save(nuevo);
        
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
