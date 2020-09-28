package com.sapient.training.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sapient.training.model.Greeting;
import com.sapient.training.service.GreetingService;

@RestController
@RequestMapping("/api")
public class GreetingController {
	@Value("${server.port}")
	private String serverPort;
	@Autowired
	private GreetingService greetingService;
	
	@GetMapping("/greet")
	public String greeting() {
		return "Hello! Welcome to producer service:"+serverPort;
	}
	
	@GetMapping("/greet/{id}")
	public ResponseEntity<Greeting> getGreetingById(@PathVariable(name = "id") Integer greetingId) {
		try {
			Greeting greeting= greetingService.getGreetingById(greetingId);
			return new ResponseEntity<>(greeting,HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
		}
	}
	
	@GetMapping("/greetall")
	public ResponseEntity<List<Greeting>> getAllGreetings() {
		try {
			List<Greeting> greetingList= 
					greetingService.getAllGreetings();
			return new ResponseEntity<>(greetingList,HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
												e.getMessage(),e);
		}
	}
}
