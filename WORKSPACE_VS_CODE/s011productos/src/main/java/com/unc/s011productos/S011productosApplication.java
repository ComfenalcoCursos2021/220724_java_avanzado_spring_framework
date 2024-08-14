package com.unc.s011productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class S011productosApplication {

	public static void main(String[] args) {
		SpringApplication.run(S011productosApplication.class, args);
	}

}
