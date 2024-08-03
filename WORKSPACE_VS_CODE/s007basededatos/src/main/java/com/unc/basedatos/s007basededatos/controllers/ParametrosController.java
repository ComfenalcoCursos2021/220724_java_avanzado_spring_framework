package com.unc.basedatos.s007basededatos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unc.basedatos.s007basededatos.entidades.ParametroEntity;
import com.unc.basedatos.s007basededatos.excepciones.TontoException;
import com.unc.basedatos.s007basededatos.repositorios.IPrametrosRepositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("api/parametro")
public class ParametrosController {

    @Autowired
    private IPrametrosRepositorio repo;

    

    @GetMapping()
    public List<ParametroEntity> getAll() {
        return this.repo.findAll();
    }

    @GetMapping("/{id}")
    public ParametroEntity getById(@PathVariable Integer id) {
        return this.repo.findById(id).get();
    }
    

    @PostMapping()
    public ParametroEntity save(@RequestBody ParametroEntity entity) {
        entity.setId(0);
        return this.repo.save(entity);
    }
    @PutMapping()
    public ParametroEntity actualizar(@RequestBody ParametroEntity entity) throws TontoException {
        
        Optional<ParametroEntity> optParametro = this.repo.findById(entity.getId());
        if(optParametro.isPresent()){
            ParametroEntity actualizar = optParametro.get();
            actualizar.setFechaActualizacion(entity.getFechaActualizacion());
            actualizar.setNombre(entity.getNombre());
            actualizar.setValor(entity.getValor());
            this.repo.save(actualizar);
            return actualizar;
        } 
        throw new TontoException("INGRESE UN DATO QUE VALGA LA PENA");       
        
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        this.repo.deleteById(id);
        return true;
    }
    
    

}
