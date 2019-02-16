package com.broada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RayvElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(RayvElasticsearchApplication.class, args);
	}

}

