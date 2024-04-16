package com.example.wastemanagerapi.utils;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Waste Manager API", version = "1.0.0", description = "Waste Manager-Backend-API"))
public class OpenApiConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("waste-manager").pathsToMatch("/api/**").build();
	}

}
