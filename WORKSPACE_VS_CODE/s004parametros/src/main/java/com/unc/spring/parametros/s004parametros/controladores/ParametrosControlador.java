package com.unc.spring.parametros.s004parametros.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/parametro")
public class ParametrosControlador {

    @GetMapping("simple")
    public String getParametroSimple(
        @RequestParam(
            name="nombre",
            required = true
            ) String name) {
        return "SIMPLE::El parametro que llego es :: " + name;
    }

    @GetMapping("varios")
    public String getParametroVarios(
        @RequestParam(
            name="nombre"            
            ) String name,
        @RequestParam(
            name="apellido"            
            ) String lastname) {


        return "VARIOS::El parametro que llego es :: " + name + " y " + lastname ;
    }


    @GetMapping("inyeccion")
    public String getMethodName(HttpServletRequest request) {

        String name = request.getParameter("nombre");
        String lastname = request.getParameter("apellido");
        return "INYECCION:: El nombre: " + name + " el apellido " + lastname;
    }
    
    
}
