package com.broada.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableEurekaClient//eureka注册
@SpringBootApplication(scanBasePackages = "com.broada")
@MapperScan("com.broada.one.data.mapper")//mybatis扫描mapper文件
@EntityScan("com.broada.one.data.domain")//扫描实体类
@ServletComponentScan(value = "com.broada.one.listener")
@EnableJpaRepositories({"com.broada.one.data.repo"})//扫描springData 文件
@Configuration
public class RayvMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RayvMybatisApplication.class, args);
	}
}

