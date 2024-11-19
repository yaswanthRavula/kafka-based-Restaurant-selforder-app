package com.Restaurant.selforder.Kafka.Consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.Restaurant.selforder.Entity.Order;
import com.Restaurant.selforder.Websocket.Services.KitchenWebsocketService;

@Service
public class KitchenConsumer {
	
	@Autowired
	KitchenWebsocketService kitchenUpdatePoster;
	
	@KafkaListener(topics = "Dining", groupId = "myGroup", containerFactory = "kafkaListenerFactory")
	public void listen(Order order) {
		System.out.println("Consuming");
		kitchenUpdatePoster.sendToWebsocketClient();
	}

}
