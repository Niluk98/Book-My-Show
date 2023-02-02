package com.example.BookMyShowBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class BookMyShowBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowBackendApplication.class, args);
	}

}
