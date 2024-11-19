package com.Restaurant.selforder.Kafka.Consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.Restaurant.selforder.Entity.Order;
import com.Restaurant.selforder.Websocket.Services.TablesWebsocketService;

@Service
public class TablesConsumer {

	@Autowired
	TablesWebsocketService tablesWebsocketService;
	
	@KafkaListener(topics = "kitchen", groupId = "myGroup", containerFactory = "kafkaListenerFactory")
	public void listen(Order order) {
		//Code to 
		//System.out.println("\n\nEntering");
		System.out.println("4");
		tablesWebsocketService.sendDetailsToTable(order.getTableNo());
	}

}
