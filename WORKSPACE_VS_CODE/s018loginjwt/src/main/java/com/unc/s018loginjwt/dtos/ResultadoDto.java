package com.unc.s018loginjwt.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class ResultadoDto<T> {
	private boolean todoOk;
	private T data;
	private String errorMessage;
	
	public static <T> ResultadoDto<T> ok(T data) {
		return ResultadoDto.<T>builder().data(data).todoOk(true).build();
	}
	public static <T> ResultadoDto<T> Falla() {
		return ResultadoDto.<T>builder().todoOk(false).build();
	}
	public static <T> ResultadoDto<T> Falla(Exception e) {
		
		return ResultadoDto.<T>builder().todoOk(false).errorMessage(e.getMessage()).build();
	}
	
}
