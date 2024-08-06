package com.unc.parametros.s009arquitectura.bl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unc.parametros.s009arquitectura.dal.ParametroDal;
import com.unc.parametros.s009arquitectura.dtos.ParametroDto;

@Service
public class ParametroBl {

    @Autowired
    private ParametroDal dal;

    private ObjectMapper mapper = new ObjectMapper();

    public ParametroDto obtenerPorId(int id )  throws JsonProcessingException {

        var optEntity = this.dal.obtenerPorId(id);
        if(optEntity.isPresent()) {

            /* OPCION 1 
            var parametroDto = new ParametroDto();
            parametroDto.setFechaActualizacion(optEntity.get().getFechaActualizacion());
            parametroDto.setId(optEntity.get().getId());
            parametroDto.setNombre(optEntity.get().getNombre());
            parametroDto.setValor(optEntity.get().getValor());
            return parametroDto;
            */
            /* OPCION 2 
            var parametroDto = ParametroDto.builder()
            .nombre(optEntity.get().getNombre())
            .fechaActualizacion(optEntity.get().getFechaActualizacion())
            .id(optEntity.get().getId())
            .valor(optEntity.get().getValor())
            .build();
            */
            /* OPCION 3 
            var entityComoTexto = this.mapper.writeValueAsString(optEntity.get());
            var parametroDto = this.mapper.readValue(entityComoTexto, ParametroDto.class);
            */
            /* OPCION 4 */
            var parametroDto = this.mapper.convertValue(optEntity.get(), ParametroDto.class);
            return parametroDto;
        }

        return null;
    }

    public List<ParametroDto> obtenerTodos() {
        var listaEntities = this.dal.obtenerTodos();
        var listaDto = listaEntities.stream()
            .map(entidad -> this.mapper.convertValue(entidad, ParametroDto.class))
            .collect(Collectors.toList());

        return listaDto;
    }

}
