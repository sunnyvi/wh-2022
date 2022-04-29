package com.order_manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.order_manage.mapper")
@ComponentScan(basePackages = {"com.order_manage.service"})
@EnableSwagger2
@ComponentScan(basePackages = {"com.order_manage.controller"})

public class OrderManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManageApplication.class, args);
	}

}

