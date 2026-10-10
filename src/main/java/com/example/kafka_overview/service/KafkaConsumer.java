package com.example.kafka_overview.service;

import com.example.kafka_overview.model.UserCustomEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(
            topics = "${topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(UserCustomEvent message) {
        System.out.println("Received: " + message);
    }
}