package com.Restaurant.selforder.Websocket.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.Restaurant.selforder.Entity.Order;
import com.Restaurant.selforder.Repositories.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class TablesWebsocketService {
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	
	
	public void sendDetailsToTable(int tableNo) {
		
		List<Order> ordersList = orderRepository.fetchAllOrderByTableNo(tableNo);
		System.out.println("After fetch:");
		for(Order order : ordersList) {
			System.out.println(order.getItemName()+" : "+order.getItemStatus());
		}
		simpMessagingTemplate.convertAndSend("topic/"+tableNo,ordersList);
	}
}
