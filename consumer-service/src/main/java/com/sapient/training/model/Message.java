package com.sapient.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message {
	private Integer id;
	private String messageFrom;
	private String message;
	private String messageTo;
	
}
