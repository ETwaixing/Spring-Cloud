package com.waixing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AccountapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountapiApplication.class, args);
	}
}
