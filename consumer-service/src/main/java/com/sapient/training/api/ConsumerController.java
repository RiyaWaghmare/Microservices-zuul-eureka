package com.sapient.training.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.sapient.training.model.Greeting;
import com.sapient.training.model.Message;
import com.sapient.training.model.NewMessage;
import com.sapient.training.model.User;
import com.sapient.training.model.WishUser;
import com.sapient.training.service.ConsumerService;
import com.sapient.training.service.UserService;

@RestController
@RequestMapping("/api")
public class ConsumerController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@Autowired
	private RestTemplate restTemplate;
	@Value("${spring.application.name}:No_Name")
	private String consumerName;

	@Autowired
	private ConsumerService consumerService;
	@Autowired
	private UserService userService;

	//http://localhost:8850/api/mess
	@GetMapping("/mess")
	public ResponseEntity<Message> getMessage(){
		try {
			String greeting=
					restTemplate.getForObject("http://producer-service/api/greet", String.class);
			Message message=
					new Message(1,"producer-service",greeting,consumerName+":"+serverPort);
			return new ResponseEntity<>(message,HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
					e.getMessage(),e);
		}
	}


	@GetMapping("/message")
	public ResponseEntity<Message> getFeignMessage(){
		try {
			String greeting= consumerService.getMessageFromProducer();

			Message message= new Message(1,"producer-service",greeting,consumerName+":"+serverPort);
			return new ResponseEntity<>(message,HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
					e.getMessage(),e);
		}
	}


	@GetMapping("/newmessage/{id}")
	public ResponseEntity<NewMessage> getNewMessage(@PathVariable Integer id){
		try {
			ResponseEntity<Greeting> greeting = 
					consumerService.getGreetingById(id);
			NewMessage newMessage= new NewMessage(1, "producer-service",
					greeting.getBody(),consumerName);
			return new ResponseEntity<>(newMessage,HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
					e.getMessage(),e);
		}
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<NewMessage>> getAllNewMessages(){
		try {
			ResponseEntity<List<Greeting>> greetingList = 
					consumerService.getAllGreetings();
			
			List<NewMessage> messageList= greetingList.getBody().stream()
			.map((g)->new NewMessage(g.getGreetingId(),
					"producer-service",g,"consumer-service"))
			.collect(Collectors.toList());
			
			return new ResponseEntity<>(messageList,HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
					e.getMessage(),e);
		}
	}
	
	@GetMapping("/wishuser/{greetid}/{userid}")
	public ResponseEntity<WishUser> getWishUser(@PathVariable Integer greetid,
						@PathVariable Integer userid){
		try {
			ResponseEntity<Greeting> greeting = 
					consumerService.getGreetingById(greetid);
			ResponseEntity<User> user = 
					userService.getUserById(userid);
			WishUser wishUser=new WishUser(1,user.getBody(),
												greeting.getBody());
			return new ResponseEntity<>(wishUser,HttpStatus.OK);
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
					e.getMessage(),e);
		}
	}
	
}
