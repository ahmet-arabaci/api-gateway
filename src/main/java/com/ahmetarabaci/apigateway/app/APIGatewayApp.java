package com.ahmetarabaci.apigateway.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ahmetarabaci.*"})
@EnableDiscoveryClient
public class APIGatewayApp {

	public static void main(String[] args) {
		SpringApplication.run(APIGatewayApp.class, args);
	}
	
}

