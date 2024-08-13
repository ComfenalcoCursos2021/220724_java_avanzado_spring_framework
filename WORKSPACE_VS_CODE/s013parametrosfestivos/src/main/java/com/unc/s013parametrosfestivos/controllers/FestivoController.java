package com.unc.s013parametrosfestivos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unc.s013parametrosfestivos.bl.FestivoBl;
import com.unc.s013parametrosfestivos.dtos.FestivoDto;
import com.unc.s013parametrosfestivos.dtos.ResultadoDto;



@RestController
@RequestMapping("api/festivo")
public class FestivoController {


    @Autowired
    private FestivoBl bl;

    @GetMapping()
    public ResultadoDto<List<FestivoDto>> obtenerTodos() {
        return this.bl.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResultadoDto<FestivoDto> obtenerPorId(@PathVariable int id) {
        return this.bl.obtenerPorId(id);
    }
    
    @PostMapping()
    public ResultadoDto<FestivoDto> guardar(@RequestBody FestivoDto dto) {
        return this.bl.guardar(dto);
    }

    @PutMapping()
    public ResultadoDto<FestivoDto> actualizar(@RequestBody FestivoDto dto) {
        return this.bl.actualizar(dto);
    }

    @DeleteMapping("/{id}")
    public ResultadoDto<FestivoDto> borrar(@PathVariable int id) {
        return this.bl.borrar(id);
    }
    
    
}
