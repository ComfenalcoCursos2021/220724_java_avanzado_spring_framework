package com.unc.arq.s010arquitenctura2.bl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unc.arq.s010arquitenctura2.dal.FestivoDal;
import com.unc.arq.s010arquitenctura2.dtos.FestivoDto;
import com.unc.arq.s010arquitenctura2.dtos.ResultadoDto;
import com.unc.arq.s010arquitenctura2.entities.FestivoEntity;

@Service
public class FestivoBl {

    @Autowired
    private FestivoDal dal;

    @Value("${usuario.atualizacion}")
    private int ID_USUARIO_ACTUALIZACION;

    @Autowired
    private GsonBuilderCustomizer gsonBuilderCustomizer;

    private ObjectMapper mapper = JsonMapper.builder()
        .addModule(new JavaTimeModule())
        .build();

    public FestivoBl(){
        DateFormat df = new SimpleDateFormat("d/MM/yyyy");
        mapper.setDateFormat(df);
    }

    public ResultadoDto obtenerPorId(int id) {

        try {
            var optEntity = this.dal.obtenerPorId(id);
            if (optEntity.isPresent()) {
                /*
                 * OPCION 1
                 * var parametroDto = new FestivoDto();
                 * parametroDto.setFechaActualizacion(optEntity.get().getFechaActualizacion());
                 * parametroDto.setId(optEntity.get().getId());
                 * parametroDto.setNombre(optEntity.get().getNombre());
                 * parametroDto.setValor(optEntity.get().getValor());
                 * return parametroDto;
                 */
                /*
                 * OPCION 2
                 * var parametroDto = FestivoDto.builder()
                 * .nombre(optEntity.get().getNombre())
                 * .fechaActualizacion(optEntity.get().getFechaActualizacion())
                 * .id(optEntity.get().getId())
                 * .valor(optEntity.get().getValor())
                 * .build();
                 */
                /*
                 * OPCION 3
                 * var entityComoTexto = this.mapper.writeValueAsString(optEntity.get());
                 * var parametroDto = this.mapper.readValue(entityComoTexto,
                 * FestivoDto.class);
                 */
                /* OPCION 4 */
                var parametroDto = this.mapper.convertValue(optEntity.get(), FestivoDto.class);
                return ResultadoDto.builder()
                        .todoOk(true)
                        .data(parametroDto)
                        .message("")
                        .build();
            }
        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.builder()
                    .todoOk(false)
                    .message("Error de ALGO :: Por favor intente mas tarde")
                    .build();
        } catch (Exception e) {
            return ResultadoDto.builder()
                    .todoOk(false)
                    .message("Error de ALGO :: " + e.getMessage() + " - " + e.getClass())
                    .build();
        }

        return ResultadoDto.builder()
                .todoOk(true)
                .message("Elemento no encontrado")
                .build();
    }

    public ResultadoDto obtenerTodos() {

        try {
            var listaEntities = this.dal.obtenerTodos();
            var listaDto = listaEntities.stream()
                    .map(entidad -> 
                    
                        
                        FestivoDto.builder()
                                                .descripcion(entidad.getDescripcion())
                                                .id(entidad.getId())
                                                .fecha(entidad.getFecha())
                                                .pais(entidad.getPais())
                                                .build()
                    
                    )
                    .collect(Collectors.toList());

            return ResultadoDto.builder()
                    .todoOk(true)
                    .message("")
                    .data(listaDto).build();

        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.builder()
                    .todoOk(false)
                    .message("Error de ALGO :: Por favor intente mas tarde")
                    .build();
        } catch (Exception e) {
            return ResultadoDto.builder()
                    .todoOk(false)
                    .message("Error de ALGO :: " + e.getMessage() + " - " + e.getClass())
                    .build();
        }
    }

    public ResultadoDto guardar(FestivoDto paraGuardarDto) {

        try {        
            
            
            //FestivoEntity paraGuardarEntity = this.mapper.convertValue(paraGuardarDto, FestivoEntity.class);
            
            
            FestivoEntity paraGuardarEntity = FestivoEntity.builder()
                                                .descripcion(paraGuardarDto.getDescripcion())
                                                .id(paraGuardarDto.getId())
                                                .fecha(paraGuardarDto.getFecha())
                                                .pais(paraGuardarDto.getPais())
                                                .build();
            
            FestivoEntity guardardoEntity = this.dal.guarda(paraGuardarEntity);
            FestivoDto guardadoDto = FestivoDto.builder()
            .descripcion(guardardoEntity.getDescripcion())
            .id(guardardoEntity.getId())
            .fecha(guardardoEntity.getFecha())
            .pais(guardardoEntity.getPais())
            .build();
            


            return ResultadoDto.builder()
                .todoOk(true)
                .data(guardadoDto)
                .build();

            
        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.builder()
                    .todoOk(false)
                    .message("Error de ALGO :: Por favor intente mas tarde")
                    .build();
        } catch (Exception e) {
            return ResultadoDto.builder()
                    .todoOk(false)
                    .message("Error de ALGO :: " + e.getMessage() + " - " + e.getClass())
                    .build();
        }
    }

    public ResultadoDto actualizar(FestivoDto paraActualizarDto) {

        try {

            FestivoEntity paraActualizarEntity = this.mapper.convertValue(paraActualizarDto, FestivoEntity.class);
            
            FestivoEntity actualizadoEntity = this.dal.actualizar(paraActualizarEntity);
            FestivoDto actualizadoDto = this.mapper.convertValue(actualizadoEntity, FestivoDto.class);

            var respuesta = ResultadoDto.builder()
                    .todoOk(actualizadoDto != null)
                    .message(actualizadoDto == null ? "El elemento no fue encontrado, por tanto no actualizo nada" : "")
                    .data(actualizadoDto)
                    .build();

            return respuesta;
        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.builder()
                    .todoOk(false)
                    .message("Error de ALGO :: Por favor intente mas tarde")
                    .build();
        } catch (Exception e) {
            return ResultadoDto.builder()
                    .todoOk(false)
                    .message("Error de ALGO :: " + e.getMessage() + " - " + e.getClass())
                    .build();
        }

    }

    public ResultadoDto borrar(int id) {

        try {

            return ResultadoDto.builder()
                    .todoOk(true)
                    .message(this.dal.borrar(id) ? "Borrado con exito" : "No fue posible borrar")
                    .build();
        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.builder()
                    .todoOk(false)
                    .message("Error de ALGO :: Por favor intente mas tarde")
                    .build();
        } catch (Exception e) {
            return ResultadoDto.builder()
                    .todoOk(false)
                    .message("Error de ALGO :: " + e.getMessage() + " - " + e.getClass())
                    .build();
        }

    }

}
