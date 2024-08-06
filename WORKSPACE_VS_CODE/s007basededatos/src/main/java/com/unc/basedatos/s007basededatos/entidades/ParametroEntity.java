package com.unc.basedatos.s007basededatos.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="PARAMETROS")
public class ParametroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String valor;
    private Date fechaActualizacion; 
    

    
    public ParametroEntity() {
    }
    public ParametroEntity(Integer id, String nombre, String valor, Date fechaActualizacion {
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
