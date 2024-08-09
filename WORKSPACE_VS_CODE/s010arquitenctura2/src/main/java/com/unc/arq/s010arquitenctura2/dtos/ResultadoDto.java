package com.unc.arq.s010arquitenctura2.dtos;

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
public class ResultadoDto <T> {

    private boolean todoOk;
    private T data;
    @Builder.Default 
    private String message = "";
}
