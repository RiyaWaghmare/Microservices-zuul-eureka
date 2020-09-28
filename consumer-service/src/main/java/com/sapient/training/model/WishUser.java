package com.sapient.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishUser {
	private Integer wishUserId;
	private User user;
	private Greeting greeting;
	
}
