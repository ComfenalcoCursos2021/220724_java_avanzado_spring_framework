package com.unc.parametros.s008lombok.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unc.parametros.s008lombok.entidades.ParametroEntity;
import com.unc.parametros.s008lombok.repositorios.IParametroRepository;

@RestController
@RequestMapping("api/parametro")
public class ParametroController {


    
    public void sandBox() {

        var nueva = new ParametroEntity();
        nueva.setId(1);
        nueva.setNombre("USUARIO POR DEFECTO");
        nueva.setValor("Invitado");
        nueva.setFechaActualizacion(new Date());

        System.out.println(nueva.getValor());

        var nueva2 = new ParametroEntity(2,"Version","1.0.1",new Date());


        var nueva3 = ParametroEntity.builder()
            .nombre("Brand")
            .valor("CPE")
            .fechaActualizacion(new Date())
            .id(3)
            .build();        
    }




    @Autowired
    private IParametroRepository repo;

    

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
    public ParametroEntity actualizar(@RequestBody ParametroEntity entity) throws Exception {
        
        Optional<ParametroEntity> optParametro = this.repo.findById(entity.getId());

        var x = "Buenas";
        
        if(optParametro.isPresent()){
            ParametroEntity actualizar = optParametro.get();
            actualizar.setFechaActualizacion(entity.getFechaActualizacion());
            actualizar.setNombre(entity.getNombre());
            actualizar.setValor(entity.getValor());
            this.repo.save(actualizar);
            return actualizar;
        } 
        throw new Exception("INGRESE UN DATO QUE VALGA LA PENA");       
        
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        this.repo.deleteById(id);
        return true;
    }

}
