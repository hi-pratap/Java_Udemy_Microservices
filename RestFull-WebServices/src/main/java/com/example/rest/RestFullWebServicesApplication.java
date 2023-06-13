package com.example.rest;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Application",
				description = "NONONONONON",
				version = "1.0",
				contact = @Contact(
						name = "Pratap",
						email = "pratap@gmail.com",
						url = "http://www.intelizign.com"
				),
				license = @License(
						name = "MIT License",
						url="http://www.opensource.org/licenses/mit-license"
				)
		),externalDocs = @ExternalDocumentation(
				description = "The documentation",
		url = "http://www.opensource.org/licenses/mit"
)
)
public class RestFullWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFullWebServicesApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
