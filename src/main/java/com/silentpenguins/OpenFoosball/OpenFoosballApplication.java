package com.silentpenguins.OpenFoosball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class OpenFoosballApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenFoosballApplication.class, args);
	}
}
