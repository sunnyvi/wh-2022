package com.custmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//@ComponentScan(basePackages = {"com"})
@MapperScan("com.custmanager.dao")
@EnableSwagger2
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})


public class CustManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustManagerApplication.class, args);
    }

}
