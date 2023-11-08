package com.facens.apibonvoyage;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Bon Voyage", version = "1.0.0"))
public class ApiBonvoyageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBonvoyageApplication.class, args);
	}

}
