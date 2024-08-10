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

    public static <T> ResultadoDto<T> ok(T data) {
        return ResultadoDto.<T>builder()
            .data(data)
            .todoOk(true)
            .message("")            
            .build();
    }
    public static <T> ResultadoDto<T> ok(String message) {
        return ResultadoDto.<T>builder()            
            .todoOk(true)
            .message(message)            
            .build();
    }

    public static <T> ResultadoDto<T> falla(String message) {
        return ResultadoDto.<T>builder()            
            .todoOk(false)
            .message(message) 
            .build();
    }


    public static <T> ResultadoDto<T> ok(T data, String message) {
        var respuesta = ResultadoDto.<T>ok(data);
        respuesta.setMessage(message);
        return respuesta;
    }
}
