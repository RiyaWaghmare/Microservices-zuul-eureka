package com.sapient.training.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sapient.training.model.Greeting;

@FeignClient(name = "producer-service")
public interface ConsumerService {

	@RequestMapping("/api/greet")
	public String getMessageFromProducer();
	
	@RequestMapping("/api/greet/{id}")
	public ResponseEntity<Greeting> getGreetingById(@PathVariable Integer id);
	
	@RequestMapping("/api/greetall")
	public ResponseEntity<List<Greeting>> getAllGreetings();
}
