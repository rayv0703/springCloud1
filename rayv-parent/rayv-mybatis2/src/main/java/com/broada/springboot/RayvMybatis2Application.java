package com.broada.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.broada")
@EnableTransactionManagement
@MapperScan({"com.broada.two.data.dao"})
@EnableDiscoveryClient
@EnableJpaRepositories({"com.broada.two.data.repo"})
@EnableFeignClients(basePackages = "com.broada.two.data.outbound")
@EntityScan("com.broada.two.data.domain")
public class RayvMybatis2Application {

	public static void main(String[] args) {
		SpringApplication.run(RayvMybatis2Application.class, args);
	}

}

