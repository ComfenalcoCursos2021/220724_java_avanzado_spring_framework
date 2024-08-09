package com.unc.arq.s010arquitenctura2.configuraciones;

import java.time.LocalDate;

import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.context.annotation.Bean;
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
