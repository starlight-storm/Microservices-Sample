package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class PenApplication {

	public static void main(String[] args) {
		SpringApplication.run(PenApplication.class, args);
	}
}
