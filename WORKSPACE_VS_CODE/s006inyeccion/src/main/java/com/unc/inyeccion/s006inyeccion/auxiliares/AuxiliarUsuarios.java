package com.unc.inyeccion.s006inyeccion.auxiliares;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unc.inyeccion.s006inyeccion.dtos.UsuarioDto;


public class AuxiliarUsuarios {

    private List<UsuarioDto> usuarios;
    
    public AuxiliarUsuarios() {
        this.usuarios = new ArrayList<UsuarioDto>();
        this.usuarios.add(new UsuarioDto(1, "Primigenio", "1234"));
    }

    public List<UsuarioDto> getTodos() {
        return this.usuarios;
    }

    public UsuarioDto addUsuario(UsuarioDto nuevo){
        nuevo.setId(this.usuarios.size() + 1);
        this.usuarios.add(nuevo);
        return nuevo;
    }

}
