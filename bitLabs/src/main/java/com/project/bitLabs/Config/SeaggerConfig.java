package com.project.bitLabs.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SeaggerConfig {
	
	@Bean
	public OpenAPI myCustome() {
		return new OpenAPI().info(new Info().title("BIT Labs").description("By Ratnesh"));
	}
}