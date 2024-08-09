package com.unc.arq.s010arquitenctura2.bl;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unc.arq.s010arquitenctura2.dal.ParametroDal;
import com.unc.arq.s010arquitenctura2.dtos.ParametroDto;
import com.unc.arq.s010arquitenctura2.dtos.ResultadoDto;
import com.unc.arq.s010arquitenctura2.entities.ParametroEntity;

@Service
public class ParametroBl {

    @Autowired
    private ParametroDal dal;

    @Value("${usuario.atualizacion}")
    private int ID_USUARIO_ACTUALIZACION;

    private ObjectMapper mapper = new ObjectMapper();

    public ResultadoDto obtenerPorId(int id) {

        try {
            var optEntity = this.dal.obtenerPorId(id);
            if (optEntity.isPresent()) {
                /*
                 * OPCION 1
                 * var parametroDto = new ParametroDto();
                 * parametroDto.setFechaActualizacion(optEntity.get().getFechaActualizacion());
                 * parametroDto.setId(optEntity.get().getId());
                 * parametroDto.setNombre(optEntity.get().getNombre());
                 * parametroDto.setValor(optEntity.get().getValor());
                 * return parametroDto;
                 */
                /*
                 * OPCION 2
                 * var parametroDto = ParametroDto.builder()
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
                 * ParametroDto.class);
                 */
                /* OPCION 4 */
                var parametroDto = this.mapper.convertValue(optEntity.get(), ParametroDto.class);
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
                    .map(entidad -> this.mapper.convertValue(entidad, ParametroDto.class))
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

    public ResultadoDto guardar(ParametroDto paraGuardarDto) {

        try {
            ParametroEntity paraGuardarEntity = this.mapper.convertValue(paraGuardarDto, ParametroEntity.class);
            paraGuardarEntity.setIdUsuarioActualizacion(this.ID_USUARIO_ACTUALIZACION);
            ParametroEntity guardardoEntity = this.dal.guarda(paraGuardarEntity);
            ParametroDto guardadoDto = this.mapper.convertValue(guardardoEntity, ParametroDto.class);
            
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

    public ResultadoDto actualizar(ParametroDto paraActualizarDto) {

        try {

            ParametroEntity paraActualizarEntity = this.mapper.convertValue(paraActualizarDto, ParametroEntity.class);
            paraActualizarEntity.setIdUsuarioActualizacion(this.ID_USUARIO_ACTUALIZACION);
            ParametroEntity actualizadoEntity = this.dal.actualizar(paraActualizarEntity);
            ParametroDto actualizadoDto = this.mapper.convertValue(actualizadoEntity, ParametroDto.class);

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
