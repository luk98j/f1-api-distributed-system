package com.api.distributed.system.apisystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableMongoRepositories
@EnableSwagger2
public class ApiSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSystemApplication.class, args);
	}

}
