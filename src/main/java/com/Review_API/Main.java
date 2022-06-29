package com.Review_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackageClasses = com.Review_API.Model.Course.class)  // force scan JPA entities
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
