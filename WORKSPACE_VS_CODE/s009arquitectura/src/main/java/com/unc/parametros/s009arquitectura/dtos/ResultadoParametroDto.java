package com.unc.parametros.s009arquitectura.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultadoParametroDto {

    private boolean todoOk;
    private List<ParametroDto> data;
    @Builder.Default 
    private String message = "";
}
