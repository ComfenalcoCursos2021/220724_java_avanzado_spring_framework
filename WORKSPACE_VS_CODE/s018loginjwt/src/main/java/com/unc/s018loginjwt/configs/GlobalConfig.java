package com.unc.s018loginjwt.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class GlobalConfig {


    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
