package com.unc.s018loginjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unc.s018loginjwt.bls.LoginBl;
import com.unc.s018loginjwt.dtos.LoginDto;
import com.unc.s018loginjwt.dtos.ResultadoDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginBl bl;

    @GetMapping
    public ResultadoDto<List<LoginDto>> findAll(){
        return this.bl.findAll();
    }
    @GetMapping("/{id}")
    public ResultadoDto<LoginDto> findById(@PathVariable long id){
        return this.bl.findById(id)
    }
    @PostMapping
    public ResultadoDto<LoginDto> save(@RequestBody LoginDto login){
        return this.bl.save(login);
    }

    @PutMapping
    public ResultadoDto<LoginDto> update(@RequestBody LoginDto login){
        return this.bl.update(login);
    }
    
    @DeleteMapping("/{id}")
    public ResultadoDto<String> delete(@PathVariable long id){
        return this.bl.delete(id);
    }

    @PostMapping("/loggeo")
    public LoginDto loggeo(@RequestBody LoginDto login ) throws Exception{
        return this.bl.loggeo(login);
    }

    @PostMapping("/validatetoken")
    public LoginDto validateToken(@PathVariable String token ) throws Exception{
        return this.bl.validateToken(token);
    }

}
