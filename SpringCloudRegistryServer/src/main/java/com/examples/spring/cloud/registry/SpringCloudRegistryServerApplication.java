package com.examples.spring.cloud.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRegistryServerApplication.class, args);
	}

}
