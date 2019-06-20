package com.examples.spring.cloud.provider;

import javax.xml.ws.RequestWrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringCloudServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServiceProviderApplication.class, args);
	}

	@GetMapping("/")
	public String greeting()
	{
		return "Greetings from Eureka Client service";
	}

}
