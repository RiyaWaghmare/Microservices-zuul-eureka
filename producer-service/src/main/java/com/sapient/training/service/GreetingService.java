package com.sapient.training.service;

import java.util.List;

import com.sapient.training.model.Greeting;

public interface GreetingService {
	public List<Greeting> getAllGreetings();
	public Greeting getGreetingById(Integer greetingId);
}
