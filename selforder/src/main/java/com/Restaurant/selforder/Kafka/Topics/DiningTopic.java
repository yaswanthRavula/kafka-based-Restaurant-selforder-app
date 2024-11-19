package com.Restaurant.selforder.Kafka.Topics;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;

public class DiningTopic {

	public NewTopic createDiningTopic() {
		return TopicBuilder.name("Dining").build();
	}
}
