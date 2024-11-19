package com.Restaurant.selforder.Websocket.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant.selforder.Entity.Order;
import com.Restaurant.selforder.Repositories.OrderRepository;

import org.springframework.messaging.simp.SimpMessagingTemplate;

@Service
public class KitchenWebsocketService {

	@Autowired
	SimpMessagingTemplate simpleMessagingTemplate;
	
	@Autowired
	OrderRepository orderRepository;
	
	
	public void sendToWebsocketClient() {
		System.out.println("In Websocket topic/kitchen");
		simpleMessagingTemplate.convertAndSend("topic/kitchen",orderRepository.findAll());
	}
}
