package com.sapient.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sapient.training.model.Greeting;

@Service
public class GreetingServiceImpl implements GreetingService{

	private List<Greeting> greetingList= new ArrayList<>();
	//instance block
	{
		greetingList.add(new Greeting(1,"Hello"));	
		greetingList.add(new Greeting(2,"Hi"));	
		greetingList.add(new Greeting(3,"Welcome"));	
		greetingList.add(new Greeting(4,"Hi, Hello"));	
		greetingList.add(new Greeting(5,"Hello, Welcome"));
	}
	
	@Override
	public List<Greeting> getAllGreetings() {			
		return greetingList;
	}

	@Override
	public Greeting getGreetingById(Integer greetingId) {
		return greetingList.get(greetingId-1);
	}

}
