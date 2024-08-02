package com.unc.inyeccion.s006inyeccion.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unc.inyeccion.s006inyeccion.auxiliares.AuxiliarUsuarios;

@Configuration
public class AquiEstanLasInstanciasParaInyectar {

    @Bean
    public AuxiliarUsuarios getAuxiliar(){
        AuxiliarUsuarios laInstancia = new AuxiliarUsuarios();
        return laInstancia;
    }
}
