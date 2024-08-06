package com.unc.parametros.s008lombok.controllers.exceptions;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.unc.parametros.s008lombok.controllers.dtos.ErrorDto;

@RestControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler({NoSuchElementException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto errorElementoNoEncontrado(Exception e){
        var error = new ErrorDto();
        error.setFecha(new Date());
        error.setMensaje("EL ELEMENTO NO FUE ENCONTRADO");
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        error.setExceptionMessage(e.getMessage());
        return error;
    }

    
    
}
