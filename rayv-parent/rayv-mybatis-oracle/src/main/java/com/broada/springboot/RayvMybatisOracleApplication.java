package com.broada.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.broada")//扫描注解，是一个复合注解，包括@ComponentScan，和@SpringBootConfiguration，@EnableAutoConfiguration。
@MapperScan("com.broada.three.data.mapper")//扫描Mapper
@EntityScan("com.broada.three.data.domain")//扫描实体类
@EnableEurekaClient//Eureka客户端
@EnableAsync//支持异步调用
public class RayvMybatisOracleApplication {
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(RayvMybatisOracleApplication.class, args);
	}

}

