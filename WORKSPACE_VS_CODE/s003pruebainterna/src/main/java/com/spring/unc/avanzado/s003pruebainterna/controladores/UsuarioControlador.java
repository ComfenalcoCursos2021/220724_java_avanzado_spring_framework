package com.spring.unc.avanzado.s003pruebainterna.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/usuario")
public class UsuarioControlador {

    @GetMapping()
    public String getUsuario(){
        return "Usuario::GET";
    }
    @PostMapping()
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity + "::POST";
    }
    

}
