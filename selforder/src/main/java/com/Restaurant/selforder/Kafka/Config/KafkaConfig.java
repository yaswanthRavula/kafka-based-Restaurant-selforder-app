package com.Restaurant.selforder.Kafka.Config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.Restaurant.selforder.Entity.Order;

@Configuration
public class KafkaConfig {
	@Bean
	public ProducerFactory<String, Order> getProperties(){
		 Map<String, Object> configProps = new HashMap<>();
	        configProps.put("bootstrap.servers", "localhost:9092");
	        configProps.put("key.serializer", JsonSerializer.class.getName()); // Use Spring's JsonSerializer
	        configProps.put("value.serializer", JsonSerializer.class.getName()); // Use Spring's JsonSerializer
	        return new DefaultKafkaProducerFactory<>(configProps);
	}
	@Bean
	public KafkaTemplate<String, Order> kafkaTemplate(){
		return new KafkaTemplate<String, Order>(getProperties());
		
	}
}
