package com.unc.s011productos.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/configuraciones")

public class ConfiguracionController {

    @Value("${miproyecto.password}")
    private String password;

    @GetMapping()
    public String getMethodName() {
        return "ElPassword - " +password;
    }
    
}
