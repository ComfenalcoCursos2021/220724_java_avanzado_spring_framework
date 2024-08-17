package com.unc.s018loginjwt.bls;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unc.s018loginjwt.dtos.LoginDto;
import com.unc.s018loginjwt.dtos.ResultadoDto;
import com.unc.s018loginjwt.entities.LoginEntity;
import com.unc.s018loginjwt.entities.dals.LoginDal;
import com.unc.s018loginjwt.services.JwtService;

@Service
public class LoginBl {

    @Autowired
    private LoginDal dal;

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private JwtService jwtService;

    public ResultadoDto<List<LoginDto>> findAll() {

        try {

            var result = this.dal.findAll();
            List<LoginDto> allData = this.mapper.map(result, new TypeToken<List<LoginDto>>() {
            }.getType());
            return ResultadoDto.<List<LoginDto>>ok(allData);
        } catch (Exception e) {
            return ResultadoDto.Falla(e);
        }

    }

    public ResultadoDto<LoginDto> findById(long id) {

        try {

            var result = this.dal.findById(id);
            LoginDto data = this.mapper.map(result, LoginDto.class);
            return ResultadoDto.<LoginDto>ok(data);
        } catch (Exception e) {
            return ResultadoDto.Falla(e);
        }

    }

    public ResultadoDto<LoginDto> save(LoginDto dto) {

        try {
            var entity = this.mapper.map(dto, LoginEntity.class);
            entity = this.dal.save(entity);
            return ResultadoDto.<LoginDto>ok(this.mapper.map(entity, LoginDto.class));

        } catch (Exception e) {
            return ResultadoDto.Falla(e);
        }

    }

    public ResultadoDto<LoginDto> update(LoginDto dto) {

        try {
            var entity = this.mapper.map(dto, LoginEntity.class);
            entity = this.dal.update(entity);
            return ResultadoDto.<LoginDto>ok(this.mapper.map(entity, LoginDto.class));

        } catch (Exception e) {
            return ResultadoDto.Falla(e);
        }

    }

    public ResultadoDto<String> delete(long id) {
        try {
            this.dal.delete(id);
            return ResultadoDto.ok("");
        } catch (Exception e) {
            return ResultadoDto.Falla(e);
        }
    }

    public LoginDto loggeo(LoginDto login) throws Exception {
        return this.jwtService.loggeo(login);
    }
    public LoginDto validateToken(String token) throws Exception{
        return this.jwtService.validateToken(token);
    }
}
