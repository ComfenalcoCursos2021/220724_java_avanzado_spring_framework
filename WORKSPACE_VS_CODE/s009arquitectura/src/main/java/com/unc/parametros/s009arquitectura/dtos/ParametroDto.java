package com.unc.parametros.s009arquitectura.dtos;

import java.util.Date;

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
public class ParametroDto {
    private Integer id;
    private String nombre;
    private String valor;
    private Date fechaActualizacion; 
}
