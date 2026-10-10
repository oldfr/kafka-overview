package com.example.kafka_overview.service;

import com.example.kafka_overview.model.UserCustomEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, UserCustomEvent> kafkaTemplate;

    public KafkaProducer(@Qualifier("Producer_Kafka_Bean") KafkaTemplate<String, UserCustomEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(UserCustomEvent message) {
        System.out.println("Pushing message:"+message.toString());
        kafkaTemplate.send("test-topic", message);
    }
}
