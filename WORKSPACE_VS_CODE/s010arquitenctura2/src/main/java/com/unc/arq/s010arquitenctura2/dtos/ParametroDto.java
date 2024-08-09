package com.unc.arq.s010arquitenctura2.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParametroDto {
    private Integer id;
    private String nombre;
    private String valor;
    private Date fechaActualizacion; 
    
}
