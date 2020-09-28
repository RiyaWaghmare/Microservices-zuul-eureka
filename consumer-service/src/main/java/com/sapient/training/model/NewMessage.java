package com.sapient.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewMessage {
	private Integer id;
	private String messageFrom;
	private Greeting greeting;
	private String messageTo;
}
