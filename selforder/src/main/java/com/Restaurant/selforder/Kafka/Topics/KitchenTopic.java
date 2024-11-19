package com.Restaurant.selforder.Kafka.Topics;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;

public class KitchenTopic {
	public NewTopic createKitchenTopic() {
		return TopicBuilder.name("kitchen").build();
	}

}
