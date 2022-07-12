package com.disney.disneyproject;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DisneyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisneyProjectApplication.class, args);
	}

	@Bean
	public GroupedOpenApi publicApi(){
		return GroupedOpenApi.builder().group("spring").packagesToScan("com.disney").build();
	}

}
