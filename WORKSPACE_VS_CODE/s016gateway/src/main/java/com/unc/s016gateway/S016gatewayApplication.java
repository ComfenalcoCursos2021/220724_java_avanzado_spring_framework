package com.unc.s016gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class S016gatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(S016gatewayApplication.class, args);
	}

}
