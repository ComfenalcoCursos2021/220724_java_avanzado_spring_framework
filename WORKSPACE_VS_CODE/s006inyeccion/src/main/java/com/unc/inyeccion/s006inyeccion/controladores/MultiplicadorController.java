package com.unc.inyeccion.s006inyeccion.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unc.inyeccion.s006inyeccion.auxiliares.AuxiliarUsuarios;
import com.unc.inyeccion.s006inyeccion.dtos.UsuarioDto;

@RestController
@RequestMapping("api/multiplicador")
public class MultiplicadorController {

    @Autowired
    private AuxiliarUsuarios auxiliar;

    @GetMapping()
    public List<UsuarioDto> getMethodName() {
        List<UsuarioDto> duplicado = new ArrayList<UsuarioDto>();
        duplicado.addAll(this.auxiliar.getTodos());
        duplicado.addAll(this.auxiliar.getTodos());
        return duplicado;
    }
}
