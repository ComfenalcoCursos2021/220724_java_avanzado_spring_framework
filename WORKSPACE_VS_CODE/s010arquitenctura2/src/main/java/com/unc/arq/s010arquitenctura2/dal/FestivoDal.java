package com.unc.arq.s010arquitenctura2.dal;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unc.arq.s010arquitenctura2.entities.FestivoEntity;
import com.unc.arq.s010arquitenctura2.repositories.IFestivoRepository;

@Repository
public class FestivoDal {

    @Autowired
    private IFestivoRepository repo;
    Random a = new Random();

    public List<FestivoEntity> obtenerTodos() throws Exception {
        if (a.nextInt(100) < 50) 
            throw new Exception("falla inesperada e incontrolada");
        

        return this.repo.findAll();

    }

    public Optional<FestivoEntity> obtenerPorId(int id) throws Exception {

        if (a.nextInt(100) < 50) 
            throw new Exception("falla inesperada e incontrolada");
            
        var op = this.repo.findById(id);
        return op;
    }

    public FestivoEntity guarda(FestivoEntity nuevo) {
        var guardado = this.repo.save(nuevo);
        return guardado;
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
