package com.maven.to.spring.endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("endpoint/usuario")
public class UsuarioEndpoint {

    @GetMapping()
    public String getMethodName() {
        return "USUARIO DESDE ENDPOINT";
    }
    
    
    
}
