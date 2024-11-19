package com.Restaurant.selforder.Kafka.Producers;

import org.apache.kafka.common.protocol.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.Restaurant.selforder.Entity.Order;

@Service
public class TableProducer {
	
	@Autowired
	KafkaTemplate<String, Order> kafkaProducer;
		
	public String addNewOrder(Order order) {
		kafkaProducer.send("Dining", order);
		return "Message Added";
	}
}
