package com.unc.parametros.s009arquitectura.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unc.parametros.s009arquitectura.bl.ParametroBl;
import com.unc.parametros.s009arquitectura.dtos.ParametroDto;
import com.unc.parametros.s009arquitectura.dtos.ResultadoParametroDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/parametro")
public class ParametroController {


    @Autowired
    private ParametroBl bl;

    @GetMapping()
    public ResultadoParametroDto obtenerTodos() {
        return this.bl.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResultadoParametroDto obtenerPorId(@PathVariable int id) {
        return this.bl.obtenerPorId(id);
    }
    
    @PostMapping()
    public ResultadoParametroDto guardar(@RequestBody ParametroDto dto) {
        return this.bl.guardar(dto);
    }

    @PutMapping()
    public ResultadoParametroDto actualizar(@RequestBody ParametroDto dto) {
        return this.bl.actualizar(dto);
    }

    @DeleteMapping("/{id}")
    public ResultadoParametroDto borrar(@PathVariable int id) {
        return this.bl.borrar(id);
    }
    
    
}
