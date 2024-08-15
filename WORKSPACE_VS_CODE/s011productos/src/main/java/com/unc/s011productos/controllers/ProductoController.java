package com.unc.s011productos.controllers;

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

import com.unc.s011productos.bl.ProductoBl;
import com.unc.s011productos.dtos.ProductoDto;
import com.unc.s011productos.dtos.ResultadoDto;



@RestController
@RequestMapping("api/producto")
public class ProductoController {


    @Autowired
    private ProductoBl bl;

    @GetMapping()
    public ResultadoDto<List<ProductoDto>> obtenerTodos() {
        return this.bl.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResultadoDto<ProductoDto> obtenerPorId(@PathVariable int id) {
        return this.bl.obtenerPorId(id);
    }
    
    @PostMapping()
    public ResultadoDto<ProductoDto> guardar(@RequestBody ProductoDto dto) {
        return this.bl.guardar(dto);
    }

    @PutMapping()
    public ResultadoDto<ProductoDto> actualizar(@RequestBody ProductoDto dto) {
        return this.bl.actualizar(dto);
    }

    @DeleteMapping("/{id}")
    public ResultadoDto<ProductoDto> borrar(@PathVariable int id) {
        return this.bl.borrar(id);
    }
    
    
}
