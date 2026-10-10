package com.example.kafka_overview.config;

import com.example.kafka_overview.model.UserEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConsumerConfig {

    @Bean("Producer_Kafka_Bean")
    public KafkaTemplate<String, UserEvent> producerKafkaTemplate(
            ProducerFactory<String, UserEvent> producerFactory) {

        return new KafkaTemplate<>(producerFactory);
    }

    @Bean("Consumer_Kafka_Bean")
    public KafkaTemplate<String, UserEvent> consumerKafkaTemplate(
            ProducerFactory<String, UserEvent> producerFactory) {

        return new KafkaTemplate<>(producerFactory);
    }
}
