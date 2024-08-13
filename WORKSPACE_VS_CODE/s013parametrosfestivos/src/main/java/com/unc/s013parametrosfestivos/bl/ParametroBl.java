package com.unc.s013parametrosfestivos.bl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unc.s013parametrosfestivos.dal.ParametroDal;
import com.unc.s013parametrosfestivos.dtos.ParametroDto;
import com.unc.s013parametrosfestivos.dtos.ResultadoDto;
import com.unc.s013parametrosfestivos.entities.ParametroEntity;

@Service
public class ParametroBl {

    @Autowired
    private ParametroDal dal;

    @Value("${usuario.atualizacion}")
    private int ID_USUARIO_ACTUALIZACION;

    private ObjectMapper mapper = new ObjectMapper();

    public ResultadoDto<ParametroDto> obtenerPorId(int id) {

        try {
            var optEntity = this.dal.obtenerPorId(id);
            if (optEntity.isPresent()) {                
                var parametroDto = this.mapper.convertValue(optEntity.get(), ParametroDto.class);
                return ResultadoDto.<ParametroDto>ok(parametroDto);
            }
        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.<ParametroDto>falla("Error de ALGO :: Por favor intente mas tarde");
                    
        } catch (Exception e) {
            return ResultadoDto.<ParametroDto>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());                    
        }

        return ResultadoDto.<ParametroDto>ok("Elemento no encontrado");
                
    }

    public ResultadoDto<List<ParametroDto>> obtenerTodos() {

        try {
            var listaEntities = this.dal.obtenerTodos();
            var listaDto = listaEntities.stream()
                    .map(entidad -> this.mapper.convertValue(entidad, ParametroDto.class))
                    .collect(Collectors.toList());

            return ResultadoDto.<List<ParametroDto>>ok(listaDto);

        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.<List<ParametroDto>>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            return ResultadoDto.<List<ParametroDto>>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());
        }
    }

    public ResultadoDto<ParametroDto> guardar(ParametroDto paraGuardarDto) {

        try {
            ParametroEntity paraGuardarEntity = this.mapper.convertValue(paraGuardarDto, ParametroEntity.class);
            paraGuardarEntity.setIdUsuarioActualizacion(this.ID_USUARIO_ACTUALIZACION);
            ParametroEntity guardardoEntity = this.dal.guarda(paraGuardarEntity);
            ParametroDto guardadoDto = this.mapper.convertValue(guardardoEntity, ParametroDto.class);
            
            return ResultadoDto.<ParametroDto>ok(guardadoDto);

            
        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.<ParametroDto>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            return ResultadoDto.<ParametroDto>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());
        }
    }

    public ResultadoDto<ParametroDto> actualizar(ParametroDto paraActualizarDto) {

        try {

            ParametroEntity paraActualizarEntity = this.mapper.convertValue(paraActualizarDto, ParametroEntity.class);
            paraActualizarEntity.setIdUsuarioActualizacion(this.ID_USUARIO_ACTUALIZACION);
            ParametroEntity actualizadoEntity = this.dal.actualizar(paraActualizarEntity);
            ParametroDto actualizadoDto = this.mapper.convertValue(actualizadoEntity, ParametroDto.class);

            var respuesta = ResultadoDto.<ParametroDto>ok
                        (
                            actualizadoDto,
                            actualizadoDto == null ? 
                            "El elemento no fue encontrado, por tanto no actualizo nada" : ""
                        );
                    

            return respuesta;
        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.<ParametroDto>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            return ResultadoDto.<ParametroDto>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());
        }

    }

    public ResultadoDto<ParametroDto> borrar(int id) {

        try {
            return ResultadoDto.<ParametroDto>ok(this.dal.borrar(id) ? "Borrado con exito" : "No fue posible borrar");
        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.<ParametroDto>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            return ResultadoDto.<ParametroDto>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());                    
        }

    }

}
