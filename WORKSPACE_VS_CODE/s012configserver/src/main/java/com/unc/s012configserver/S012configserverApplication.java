package com.unc.s012configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class S012configserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(S012configserverApplication.class, args);
	}

}
