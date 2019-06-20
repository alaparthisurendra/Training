package com.examples.spring.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudEmpServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEmpServiceProviderApplication.class, args);
	}

}
