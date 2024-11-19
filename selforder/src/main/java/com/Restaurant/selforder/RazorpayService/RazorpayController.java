package com.Restaurant.selforder.RazorpayService;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@CrossOrigin("*")
@RestController
@RequestMapping("razopay/orders")
public class RazorpayController {
	
	RazorpayClient razorpayClient;

	@PostMapping("createNewOrder")
	public String newOrder(@RequestParam int amount) {
		Order order;
		try {
			razorpayClient =  new RazorpayClient("rzp_test_cPL45prHGl0cgJ","mp0jKmpUPPLh5x7lsucsAkJp");
		System.out.println("Amount "+amount);
		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", (amount*100));
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "receipt#1");
        orderRequest.put("payment_capture", 1); // Auto capture payment
		order = new Order(orderRequest);
		 order =razorpayClient.orders.create(orderRequest);
		 return order.toString();
		}catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		//return order;
	}
}
