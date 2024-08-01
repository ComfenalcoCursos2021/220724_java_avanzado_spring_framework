package com.unc.spring.parametros.s004parametros.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unc.spring.parametros.s004parametros.dto.UsuarioDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/usuariofake")
public class UsuarioFakeControlador {

    private List<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();
    
    public UsuarioFakeControlador() {
        usuarios.add(new UsuarioDto(1, "Pepito", "pep", "1234"));
        usuarios.add(new UsuarioDto(2, "Rodrigo", "Rod", "1234"));
        usuarios.add(new UsuarioDto(3, "Camilo", "Cam", "1234"));
    }
    
    @GetMapping("consultartodos")
    public List<UsuarioDto> getUsuarios() {
        return this.usuarios;
    }

    @GetMapping("consultaruno/{id}")
    public UsuarioDto getUsuarioById(@PathVariable int id) {
        UsuarioDto buscado = null;
        for (UsuarioDto usuarioDto : usuarios) {
            if(usuarioDto.getId() == id){
                buscado = usuarioDto;
                break;
            }
        }
        return buscado;
    }
    
    
    @GetMapping("find")
    public UsuarioDto getUsuario(@RequestParam() int id) {

        UsuarioDto buscado = null;
        /*for (UsuarioDto usuarioDto : usuarios) {
            if(usuarioDto.getId() == id){
                buscado = usuarioDto;
            }
        }*/

        for(int i = 0 ; i < this.usuarios.size() ; i ++ ){
            UsuarioDto usuarioDto = this.usuarios.get(i);
            if(usuarioDto.getId() == id){
                buscado = usuarioDto;
                break;
            }
        }
        return buscado;
    }

    @GetMapping("guardar")
    public UsuarioDto guardar(@RequestBody UsuarioDto nuevo) {

        nuevo.setId(this.usuarios.size()+1);
        this.usuarios.add(nuevo);

        return nuevo;

    }
    @GetMapping("actualizar")
    public UsuarioDto actualizar(@RequestBody UsuarioDto nuevo) throws Exception {

        
        UsuarioDto buscado = null;

        for (UsuarioDto usuarioDto : usuarios) {
            if(usuarioDto.getId() == nuevo.getId()){
                buscado = usuarioDto;
                break;
            }
        }
        if(buscado != null){
            buscado.setNick(nuevo.getNick());
            buscado.setNombre(nuevo.getNombre());
            buscado.setPassword(nuevo.getPassword());
        } else {
            throw new IOException("Error, el usuario no existe");
        }

        return buscado;

    }


    @GetMapping("borrar/{id}")
    public void borrar(@PathVariable int id){
        UsuarioDto buscado = null;
        for (UsuarioDto usuarioDto : usuarios) {
            if(usuarioDto.getId() == id){
                buscado = usuarioDto;
                break;
            }
        }
        if(buscado != null){
            this.usuarios.remove(buscado);
        } else {
            throw new IndexOutOfBoundsException("Error, el usuario no existe");
        }

    }

}
