package com.spring.unc.avanzado.s003pruebainterna.controladores;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prueba")
public class PruebaControlador {

    @GetMapping()
    public String getMethodPrueba() {
        return "SALUDOS DESDE AQUI DESDE S003 CREADO INTERNAMENTE Y AHORA - " + (new Date()).toString();
    }
}
