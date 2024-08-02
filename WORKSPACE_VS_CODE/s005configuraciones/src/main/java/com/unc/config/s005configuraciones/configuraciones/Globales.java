package com.unc.config.s005configuraciones.configuraciones;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
    
    @PropertySource(value="classpath:miproyecto.properties", encoding = "UTF-8")

})
public class Globales {

}
