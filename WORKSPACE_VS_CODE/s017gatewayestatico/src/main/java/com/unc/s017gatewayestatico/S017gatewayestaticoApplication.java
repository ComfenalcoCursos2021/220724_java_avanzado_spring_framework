package com.unc.s017gatewayestatico;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S017gatewayestaticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(S017gatewayestaticoApplication.class, args);
	}



	@Value("${service.producto}")
	private int productoPuerto;

	@Bean
	public RouteLocator tablaRutas(RouteLocatorBuilder builder){
		return builder.routes()
			.route(ruta -> 			
				ruta
					.path("/api/festivo/{id}","/api/festivo")
					.uri("http://localhost:10116/api/festivo"))
			.route(ruta -> 			
				ruta
					.path("/api/parametro/{id}","/api/parametro")
					.uri("http://localhost:10116/api/parametro"))
			.route(ruta -> 			
				ruta
					.path("/api/producto/{id}","/api/producto")
					.uri("http://localhost:"+productoPuerto+"/api/producto"))
			.route(ruta -> 			
				ruta
					.path("/api/configuraciones/{id}","/api/configuraciones")
					.uri("http://localhost:"+productoPuerto+"/api/configuraciones"))
			.build();
	}

}
