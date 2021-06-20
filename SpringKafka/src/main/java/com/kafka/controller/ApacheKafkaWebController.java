package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.service.KafkaSender;

@RestController
@RequestMapping(value="/javainuse-kafka")
public class ApacheKafkaWebController {

	@Autowired
	KafkaSender kafka_sender;
	
	@GetMapping(value = "producer")
	public String producer(@RequestParam("message") String message) {
		
		kafka_sender.send(message);
		return "Sent message successfully to the topic first_sender";
	}
	
	
}
