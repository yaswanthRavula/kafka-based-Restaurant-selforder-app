package com.Restaurant.selforder.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Restaurant.selforder.Entity.Order;
import com.Restaurant.selforder.Kafka.Producers.KitchenProducer;
import com.Restaurant.selforder.Kafka.Producers.TableProducer;
import com.Restaurant.selforder.Repositories.OrderRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin("*")
@RequestMapping("kitchen")
public class KitchenController {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
   TableProducer tableProducer ;
	@Autowired
	KitchenProducer kitchenProducer;
	
	@Autowired
	EntityManager entityManager;
	
	@PostMapping("newOrder")
	public List<Order> newOrderArrived(@RequestBody Order order) {
	System.out.println("Enteirng");
		orderRepository.save(order);
		tableProducer.addNewOrder(order);
		return orderRepository.fetchAllOrderByTableNo(order.getTableNo());
	}
	
	@PostMapping("updateOrderStatus")
	public List<Order> updateOrder(@RequestBody Order order) {
		orderRepository.save(order);
		//orderRepository.flush();
		
		kitchenProducer.updateOrder(order);
		List<Order> list = orderRepository.findAll();
		
		return list;
	}
	
	@GetMapping("getItemsByTableNo")
	public List<Order> getItemsByTableNo(@RequestParam("tableNo") int tableNo){
		return orderRepository.fetchAllOrderByTableNo(tableNo);
	}
	
	@GetMapping("getKithcenItems")
	public List<Order> getAllItemsForKitchen(){
		return orderRepository.findAll();
	}
	
	@GetMapping("deleteListByTableNo")
	@Transactional
	public void deleteListByTableNo(@RequestParam int tableNo) {
		 orderRepository.deleteAllItemsOnTable(tableNo);
	}

}
