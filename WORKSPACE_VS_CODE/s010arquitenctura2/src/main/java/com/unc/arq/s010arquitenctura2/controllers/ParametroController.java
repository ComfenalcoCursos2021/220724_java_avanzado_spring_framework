package com.unc.arq.s010arquitenctura2.controllers;

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

import com.unc.arq.s010arquitenctura2.bl.ParametroBl;
import com.unc.arq.s010arquitenctura2.dtos.ParametroDto;
import com.unc.arq.s010arquitenctura2.dtos.ResultadoDto;



@RestController
@RequestMapping("api/parametro")
public class ParametroController {


    @Autowired
    private ParametroBl bl;

    @GetMapping()
    public ResultadoDto<List<ParametroDto>> obtenerTodos() {
        return this.bl.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResultadoDto<ParametroDto> obtenerPorId(@PathVariable int id) {
        return this.bl.obtenerPorId(id);
    }
    
    @PostMapping()
    public ResultadoDto<ParametroDto> guardar(@RequestBody ParametroDto dto) {
        return this.bl.guardar(dto);
    }

    @PutMapping()
    public ResultadoDto<ParametroDto> actualizar(@RequestBody ParametroDto dto) {
        return this.bl.actualizar(dto);
    }

    @DeleteMapping("/{id}")
    public ResultadoDto<ParametroDto> borrar(@PathVariable int id) {
        return this.bl.borrar(id);
    }
    
    
}
