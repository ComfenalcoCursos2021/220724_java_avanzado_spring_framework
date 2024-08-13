package com.unc.s013parametrosfestivos.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unc.s013parametrosfestivos.entities.FestivoEntity;
import com.unc.s013parametrosfestivos.repositories.IFestivoRepository;

@Repository
public class FestivoDal {

    @Autowired
    private IFestivoRepository repo;    

    public List<FestivoEntity> obtenerTodos() throws Exception {
        return this.repo.findAll();
    }

    public Optional<FestivoEntity> obtenerPorId(int id) throws Exception {
        return this.repo.findById(id);        
    }

    public FestivoEntity guarda(FestivoEntity nuevo) {
        return this.repo.save(nuevo);
        
    }

    public FestivoEntity actualizar(FestivoEntity paraActualizar) throws Exception {

        var optGuardado = this.obtenerPorId(paraActualizar.getId());

        if (optGuardado.isPresent()) {
            var guardado = optGuardado.get();
            guardado.setFecha(paraActualizar.getFecha());
            guardado.setDescripcion(paraActualizar.getDescripcion());
            guardado.setPais(paraActualizar.getPais());
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
