package com.sapient.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sapient.training.model.User;

@Service
public class UserServiceImpl implements UserService{
	private List<User> userList= new ArrayList<>();
	{
		userList.add(new User(1,"Rohit"));
		userList.add(new User(2,"Rahul Dev"));
		userList.add(new User(3,"Mohan Kumar"));
		userList.add(new User(4,"Ramya"));
		userList.add(new User(5,"Kavya"));
	}
	
	@Override
	public User getUserById(Integer userId) {		
		return userList.get(userId-1);
	}

	@Override
	public List<User> getUsers() {
		return userList;
	}

}
