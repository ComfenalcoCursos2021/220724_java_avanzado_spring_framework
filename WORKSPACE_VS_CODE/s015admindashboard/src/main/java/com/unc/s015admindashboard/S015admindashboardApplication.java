package com.unc.s015admindashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class S015admindashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(S015admindashboardApplication.class, args);
	}

}
