package com.sapient.training.service;

import java.util.List;

import com.sapient.training.model.User;

public interface UserService {
	public User getUserById(Integer userId);
	public List<User> getUsers();
}
