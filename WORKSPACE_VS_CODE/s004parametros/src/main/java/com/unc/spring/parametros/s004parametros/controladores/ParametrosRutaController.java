package com.unc.spring.parametros.s004parametros.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/parametroruta")
public class ParametrosRutaController {


    @GetMapping("enruta/{parametro1}")
    public String getMethodName(@PathVariable String parametro1) {
        return "PARAMETRO:RUTA::" + parametro1;
    }


    @GetMapping("enruta/{parametro1}/{parametro2}")
    public String getMethodName(@PathVariable String parametro1,@PathVariable String parametro2) {
        return "PARAMETRO:RUTA::parametro1=>" + parametro1+ " parametro2=>"+parametro2;
    }
    

}
