package com.sapient.training.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sapient.training.model.User;

@FeignClient(name = "user-service")
public interface UserService {

	@RequestMapping("/api/users/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Integer userId);
	@RequestMapping("/api/users")
	public ResponseEntity<List<User>> getUsers();
}
