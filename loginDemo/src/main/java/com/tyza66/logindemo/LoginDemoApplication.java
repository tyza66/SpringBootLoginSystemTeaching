package com.tyza66.logindemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tyza66.logindemo.mapper")
public class LoginDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginDemoApplication.class, args);
	}

}
