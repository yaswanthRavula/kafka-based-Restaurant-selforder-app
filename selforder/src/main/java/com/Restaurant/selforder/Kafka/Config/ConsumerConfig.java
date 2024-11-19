package com.Restaurant.selforder.Kafka.Config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.Restaurant.selforder.Entity.Order;

@Configuration
public class ConsumerConfig {
	
	@Bean
	public org.springframework.kafka.core.ConsumerFactory<String, Order> consumerFactory(){
		Map<String, Object> configProps = new HashMap<>();
        configProps.put("bootstrap.servers", "localhost:9092");
        configProps.put("group.id", "myGroup");
        configProps.put("key.deserializer", JsonDeserializer.class.getName());
        configProps.put("value.deserializer", JsonDeserializer.class.getName());
        configProps.put(JsonDeserializer.VALUE_DEFAULT_TYPE, Order.class.getName()); // Specify the target class for deserialization
        configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(configProps);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Order> kafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Order>  factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
		}
} 
