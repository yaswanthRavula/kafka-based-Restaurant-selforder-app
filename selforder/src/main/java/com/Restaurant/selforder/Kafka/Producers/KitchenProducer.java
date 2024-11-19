package com.Restaurant.selforder.Kafka.Producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.Restaurant.selforder.Entity.Order;

@Service
public class KitchenProducer {

	@Autowired
    KafkaTemplate< String, Order> kafkaTemplate;
	
	public void updateOrder(Order order) {
		System.out.println("3");
		kafkaTemplate.send("kitchen", order);
	}
}
