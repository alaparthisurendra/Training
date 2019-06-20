package com.examples.spring.cloud.consumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringCloudEmpServiceConsumerApplication implements CommandLineRunner {

	@Autowired
	DiscoveryClient discoveryClient;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEmpServiceConsumerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {


		System.out.println(discoveryClient);

		List<ServiceInstance> instances = discoveryClient.getInstances("serviceprovider");
		if (instances.size() > 0) {
			URI baseUri = instances.get(0).getUri();
			
			
			URI listEmployees = new URI(baseUri + "/employees");
			System.out.println(listEmployees.toString());

			RestTemplate client = new RestTemplate();
			
			RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, listEmployees);
			ResponseEntity<String> response = client.exchange(request, String.class);

			System.out.println(response.getBody());
		}
	}	

}
