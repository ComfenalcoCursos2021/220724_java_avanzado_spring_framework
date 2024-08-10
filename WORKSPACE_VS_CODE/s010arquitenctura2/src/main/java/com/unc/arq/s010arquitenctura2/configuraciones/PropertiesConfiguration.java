package com.unc.arq.s010arquitenctura2.configuraciones;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(
    {
        @PropertySource("classpath:project.properties")
    }
)
public class PropertiesConfiguration {

    

}
