package com.unc.inyeccion.s006inyeccion.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unc.inyeccion.s006inyeccion.auxiliares.AuxiliarUsuarios;
import com.unc.inyeccion.s006inyeccion.dtos.UsuarioDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/usuario")
public class UsuarioControlador {


    @Autowired
    private AuxiliarUsuarios auxiliar;

    @GetMapping()
    public List<UsuarioDto> getMethodName() {
        return auxiliar.getTodos();
    }

    @PostMapping()
    public UsuarioDto guardar(@RequestBody UsuarioDto nuevo) {
        return this.auxiliar.addUsuario(nuevo);
    }
    
    
}
