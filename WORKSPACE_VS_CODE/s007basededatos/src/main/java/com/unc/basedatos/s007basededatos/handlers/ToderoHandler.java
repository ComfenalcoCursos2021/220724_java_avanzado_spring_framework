package com.unc.basedatos.s007basededatos.handlers;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.unc.basedatos.s007basededatos.dtos.ErrorDto;
import com.unc.basedatos.s007basededatos.excepciones.TontoException;

@RestControllerAdvice
public class ToderoHandler {


    @ExceptionHandler({NoSuchElementException.class, TontoException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto errorElementoNoEncontrado(Exception e){
        ErrorDto error = new ErrorDto();
        error.setFecha(new Date());
        error.setMensaje("EL ELEMENTO NO FUE ENCONTRADO");
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        error.setExceptionMessage(e.getMessage());
        return error;
    }

    /* 
    @ExceptionHandler({TontoException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorDto errorElementoNoEncontrado(TontoException e){
        ErrorDto error = new ErrorDto();
        error.setFecha(new Date());
        error.setMensaje("intente nuevamente");
        error.setStatus(HttpStatus.CONFLICT.toString());
        error.setExceptionMessage(e.getMessage());
        return error;
    }*/
}
