package com.sust.onlineorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages="com.sust.onlineorder")
@MapperScan("com.sust.onlineorder.dao")
public class OnlineOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineOrderApplication.class, args);
	}

}

