package com.unc.parametros.s008lombok.controllers.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {

    private String mensaje;
    private String exceptionMessage;
    private String status;
    private Date fecha;
}
