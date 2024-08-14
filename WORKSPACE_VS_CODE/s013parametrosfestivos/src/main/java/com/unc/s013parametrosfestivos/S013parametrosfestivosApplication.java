package com.unc.s013parametrosfestivos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class S013parametrosfestivosApplication {

	public static void main(String[] args) {
		SpringApplication.run(S013parametrosfestivosApplication.class, args);
	}

}
