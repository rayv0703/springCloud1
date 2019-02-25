package com.broada.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.broada")
@MapperScan("com.broada.three.data.mapper")
@EntityScan("com.broada.three.data.domain")
@EnableJpaRepositories("com.broada.three.data.repo")
public class RayvMybatisOracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RayvMybatisOracleApplication.class, args);
	}

}

