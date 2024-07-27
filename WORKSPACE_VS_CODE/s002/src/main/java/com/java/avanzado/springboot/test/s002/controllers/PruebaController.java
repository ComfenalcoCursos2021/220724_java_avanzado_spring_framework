package com.java.avanzado.springboot.test.s002.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/prueba")
public class PruebaController {

    @GetMapping()
    public String getMethodPrueba() {
        return "SALUDOS DESDE AQUI Y AHORA - " + (new Date()).toString();
    }
    
}
