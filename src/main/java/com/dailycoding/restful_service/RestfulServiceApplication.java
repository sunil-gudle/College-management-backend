package com.dailycoding.restful_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
@SpringBootApplication
public class RestfulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulServiceApplication.class, args);
	}

}
