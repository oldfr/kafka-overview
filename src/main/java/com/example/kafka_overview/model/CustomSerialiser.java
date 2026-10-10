package com.example.kafka_overview.model;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

public class CustomSerialiser<UserEvent> implements Serializer<UserEvent> {


    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Initialization logic if you need to read custom configurations
    }

    @Override
    public byte[] serialize(String topic, UserEvent data) {
        if (data == null) {
            return null;
        }
        try {
            // Convert the object to a JSON byte array
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error serializing object to byte[] via Jackson", e);
        }
    }

    @Override
    public void close() {
        // Cleanup resources here if required
    }
}
