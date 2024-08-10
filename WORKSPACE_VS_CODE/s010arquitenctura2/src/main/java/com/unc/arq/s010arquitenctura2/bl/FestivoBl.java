package com.unc.arq.s010arquitenctura2.bl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.unc.arq.s010arquitenctura2.configuraciones.LocalDateDeserializer;
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

    private ObjectMapper mapper = new ObjectMapper();

    public FestivoBl() {
        mapper.registerModule(new JavaTimeModule());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        mapper.setDateFormat(dateFormat);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.registerModule(new SimpleModule().addDeserializer(LocalDate.class, new LocalDateDeserializer()));

    }

    public ResultadoDto<FestivoDto> obtenerPorId(int id) {

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
                var festivoDto = this.mapper.convertValue(optEntity.get(), FestivoDto.class);
                /*
                 * return ResultadoDto.<FestivoDto>builder()
                 * .todoOk(true)
                 * .data(festivoDto)
                 * .message("")
                 * .build();
                 */
                return ResultadoDto.<FestivoDto>ok(festivoDto);

            }
        } catch (CannotCreateTransactionException e) {
            /*
             * return ResultadoDto.<FestivoDto>builder()
             * .todoOk(false)
             * .message("Error de ALGO :: Por favor intente mas tarde")
             * .build();
             */
            return ResultadoDto.<FestivoDto>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            /*
             * return ResultadoDto.<FestivoDto>builder()
             * .todoOk(false)
             * .message("Error de ALGO :: " + e.getMessage() + " - " + e.getClass())
             * .build();
             */
            return ResultadoDto.<FestivoDto>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());
        }

        /*
         * return ResultadoDto.<FestivoDto>builder()
         * .todoOk(true)
         * .message("Elemento no encontrado")
         * .build();
         */
        return ResultadoDto.<FestivoDto>ok("Elemento no encontrado");
    }

    public ResultadoDto<List<FestivoDto>> obtenerTodos() {

        try {
            var listaEntities = this.dal.obtenerTodos();
            List<FestivoDto> listaDto = listaEntities.stream()
                    .map(entidad ->

                    FestivoDto.builder()
                            .descripcion(entidad.getDescripcion())
                            .id(entidad.getId())
                            .fecha(entidad.getFecha())
                            .pais(entidad.getPais())
                            .build()

                    )
                    .collect(Collectors.<FestivoDto>toList());

            /*
             * return ResultadoDto.<List<FestivoDto>>builder()
             * .todoOk(true)
             * .message("")
             * .data(listaDto).build();
             */
            return ResultadoDto.<List<FestivoDto>>ok(listaDto);

        } catch (CannotCreateTransactionException e) {
            /*
             * return ResultadoDto.<List<FestivoDto>>builder()
             * .todoOk(false)
             * .message("Error de ALGO :: Por favor intente mas tarde")
             * .build();
             */
            return ResultadoDto.<List<FestivoDto>>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            /*
             * return ResultadoDto.<List<FestivoDto>>builder()
             * .todoOk(false)
             * .message("Error de ALGO :: " + e.getMessage() + " - " + e.getClass())
             * .build();
             */
            return ResultadoDto.<List<FestivoDto>>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());
        }
    }

    public ResultadoDto<FestivoDto> guardar(FestivoDto paraGuardarDto) {

        try {

            // FestivoEntity paraGuardarEntity = this.mapper.convertValue(paraGuardarDto,
            // FestivoEntity.class);

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

            /*
             * return ResultadoDto.<FestivoDto>builder()
             * .todoOk(true)
             * .data(guardadoDto)
             * .build();
             */
            return ResultadoDto.<FestivoDto>ok(guardadoDto);

        } catch (CannotCreateTransactionException e) {
            /*
             * return ResultadoDto.<FestivoDto>builder()
             * .todoOk(false)
             * .message("Error de ALGO :: Por favor intente mas tarde")
             * .build();
             */
            return ResultadoDto.<FestivoDto>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            /*
             * return ResultadoDto.<FestivoDto>builder()
             * .todoOk(false)
             * .message("Error de ALGO :: " + e.getMessage() + " - " + e.getClass())
             * .build();
             */
            return ResultadoDto.<FestivoDto>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());
        }
    }

    public ResultadoDto<FestivoDto> actualizar(FestivoDto paraActualizarDto) {

        try {

            FestivoEntity paraActualizarEntity = this.mapper.convertValue(paraActualizarDto, FestivoEntity.class);

            FestivoEntity actualizadoEntity = this.dal.actualizar(paraActualizarEntity);
            FestivoDto actualizadoDto = this.mapper.convertValue(actualizadoEntity, FestivoDto.class);

            var respuesta = ResultadoDto.<FestivoDto>builder()
                    .todoOk(actualizadoDto != null)
                    .message(actualizadoDto == null ? "El elemento no fue encontrado, por tanto no actualizo nada" : "")
                    .data(actualizadoDto)
                    .build();

            return respuesta;
        } catch (CannotCreateTransactionException e) {
            /*
             * return ResultadoDto.<FestivoDto>builder()
             * .todoOk(false)
             * .message("Error de ALGO :: Por favor intente mas tarde")
             * .build();
             */
            return ResultadoDto.<FestivoDto>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            /*
             * return ResultadoDto.<FestivoDto>builder()
             * .todoOk(false)
             * .message("Error de ALGO :: " + e.getMessage() + " - " + e.getClass())
             * .build();
             */
            return ResultadoDto.<FestivoDto>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());
        }

    }

    public ResultadoDto<FestivoDto> borrar(int id) {

        try {

            /*return ResultadoDto.<FestivoDto>builder()
                    .todoOk(true)
                    .message(this.dal.borrar(id) ? "Borrado con exito" : "No fue posible borrar")
                    .build();*/
            return ResultadoDto.<FestivoDto>ok(this.dal.borrar(id) ? "Borrado con exito" : "No fue posible borrar");
        } catch (CannotCreateTransactionException e) {
            /*return ResultadoDto.<FestivoDto>builder()
                    .todoOk(false)
                    .message("Error de ALGO :: Por favor intente mas tarde")
                    .build();*/
                    return ResultadoDto.<FestivoDto>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            /*return ResultadoDto.<FestivoDto>builder()
                    .todoOk(false)
                    .message("Error de ALGO :: " + e.getMessage() + " - " + e.getClass())
                    .build();*/
                    return ResultadoDto.<FestivoDto>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());
        }

    }

}
