package com.unc.s018loginjwt.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class LoginDto {

    private Long id;
    private String user;
    private String password;
    private String token;
}
