package com.unc.s011productos.bl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unc.s011productos.dal.ProductoDal;
import com.unc.s011productos.dtos.ProductoDto;
import com.unc.s011productos.dtos.ResultadoDto;
import com.unc.s011productos.entities.ProductoEntity;

@Service
public class ProductoBl {

    @Autowired
    private ProductoDal dal;

    @Value("${usuario.atualizacion}")
    private int ID_USUARIO_ACTUALIZACION;

    private ObjectMapper mapper = new ObjectMapper();

    public ResultadoDto<ProductoDto> obtenerPorId(int id) {

        try {
            var optEntity = this.dal.obtenerPorId(id);
            if (optEntity.isPresent()) {                
                var parametroDto = this.mapper.convertValue(optEntity.get(), ProductoDto.class);
                return ResultadoDto.<ProductoDto>ok(parametroDto);
            }
        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.<ProductoDto>falla("Error de ALGO :: Por favor intente mas tarde");
                    
        } catch (Exception e) {
            return ResultadoDto.<ProductoDto>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());                    
        }

        return ResultadoDto.<ProductoDto>ok("Elemento no encontrado");
                
    }

    public ResultadoDto<List<ProductoDto>> obtenerTodos() {

        try {
            var listaEntities = this.dal.obtenerTodos();
            var listaDto = listaEntities.stream()
                    .map(entidad -> this.mapper.convertValue(entidad, ProductoDto.class))
                    .collect(Collectors.toList());

            return ResultadoDto.<List<ProductoDto>>ok(listaDto);

        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.<List<ProductoDto>>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            return ResultadoDto.<List<ProductoDto>>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());
        }
    }

    public ResultadoDto<ProductoDto> guardar(ProductoDto paraGuardarDto) {

        try {
            ProductoEntity paraGuardarEntity = this.mapper.convertValue(paraGuardarDto, ProductoEntity.class);
            paraGuardarEntity.setIdUsuarioActualizacion(this.ID_USUARIO_ACTUALIZACION);
            ProductoEntity guardardoEntity = this.dal.guarda(paraGuardarEntity);
            ProductoDto guardadoDto = this.mapper.convertValue(guardardoEntity, ProductoDto.class);
            
            return ResultadoDto.<ProductoDto>ok(guardadoDto);

            
        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.<ProductoDto>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            return ResultadoDto.<ProductoDto>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());
        }
    }

    public ResultadoDto<ProductoDto> actualizar(ProductoDto paraActualizarDto) {

        try {

            ProductoEntity paraActualizarEntity = this.mapper.convertValue(paraActualizarDto, ProductoEntity.class);
            paraActualizarEntity.setIdUsuarioActualizacion(this.ID_USUARIO_ACTUALIZACION);
            ProductoEntity actualizadoEntity = this.dal.actualizar(paraActualizarEntity);
            ProductoDto actualizadoDto = this.mapper.convertValue(actualizadoEntity, ProductoDto.class);

            var respuesta = ResultadoDto.<ProductoDto>ok
                        (
                            actualizadoDto,
                            actualizadoDto == null ? 
                            "El elemento no fue encontrado, por tanto no actualizo nada" : ""
                        );
                    

            return respuesta;
        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.<ProductoDto>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            return ResultadoDto.<ProductoDto>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());
        }

    }

    public ResultadoDto<ProductoDto> borrar(int id) {

        try {
            return ResultadoDto.<ProductoDto>ok(this.dal.borrar(id) ? "Borrado con exito" : "No fue posible borrar");
        } catch (CannotCreateTransactionException e) {
            return ResultadoDto.<ProductoDto>falla("Error de ALGO :: Por favor intente mas tarde");
        } catch (Exception e) {
            return ResultadoDto.<ProductoDto>falla("Error de ALGO :: " + e.getMessage() + " - " + e.getClass());                    
        }

    }

}
