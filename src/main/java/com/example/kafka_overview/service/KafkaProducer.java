package com.example.kafka_overview.service;

import com.example.kafka_overview.model.UserEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, UserEvent> kafkaTemplate;

    public KafkaProducer(@Qualifier("Producer_Kafka_Bean") KafkaTemplate<String, UserEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(UserEvent message) {
        kafkaTemplate.send("test-topic", message);
    }
}
