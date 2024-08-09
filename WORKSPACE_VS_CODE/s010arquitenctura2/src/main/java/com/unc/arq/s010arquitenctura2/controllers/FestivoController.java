package com.unc.arq.s010arquitenctura2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unc.arq.s010arquitenctura2.bl.FestivoBl;
import com.unc.arq.s010arquitenctura2.dtos.FestivoDto;
import com.unc.arq.s010arquitenctura2.dtos.ResultadoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/festivo")
public class FestivoController {


    @Autowired
    private FestivoBl bl;

    @GetMapping()
    public ResultadoDto obtenerTodos() {
        return this.bl.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResultadoDto obtenerPorId(@PathVariable int id) {
        return this.bl.obtenerPorId(id);
    }
    
    @PostMapping()
    public ResultadoDto guardar(@RequestBody FestivoDto dto) {
        return this.bl.guardar(dto);
    }

    @PutMapping()
    public ResultadoDto actualizar(@RequestBody FestivoDto dto) {
        return this.bl.actualizar(dto);
    }

    @DeleteMapping("/{id}")
    public ResultadoDto borrar(@PathVariable int id) {
        return this.bl.borrar(id);
    }
    
    
}
