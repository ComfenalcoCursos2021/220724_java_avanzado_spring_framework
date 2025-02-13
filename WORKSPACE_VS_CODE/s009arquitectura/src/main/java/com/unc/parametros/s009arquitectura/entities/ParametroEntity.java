package com.unc.parametros.s009arquitectura.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PARAMETROS")

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParametroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String valor;
    private Date fechaActualizacion; 
    private Integer IdUsuarioActualizacion;
}
