package com.example.kafka_overview.config;

import com.example.kafka_overview.model.UserCustomEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConsumerConfig {

    @Bean("Producer_Kafka_Bean")
    public KafkaTemplate<String, UserCustomEvent> producerKafkaTemplate(
            ProducerFactory<String, UserCustomEvent> producerFactory) {

        return new KafkaTemplate<>(producerFactory);
    }
}
