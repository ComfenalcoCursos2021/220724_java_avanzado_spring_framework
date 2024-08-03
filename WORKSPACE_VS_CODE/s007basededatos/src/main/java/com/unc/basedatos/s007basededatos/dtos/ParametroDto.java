package com.unc.basedatos.s007basededatos.dtos;

import java.util.Date;

public class ParametroDto {
    private Integer id;
    private String nombre;
    private String valor;
    private Date fechaActualizacion;
    
    public ParametroDto() {
    }
    
    public ParametroDto(Integer id, String nombre, String valor, Date fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    } 

    
}
