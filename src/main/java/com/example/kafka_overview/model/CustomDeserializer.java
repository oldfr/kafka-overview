package com.example.kafka_overview.model;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import tools.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.Map;


public class CustomDeserializer implements Deserializer<UserCustomEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No extra configuration needed
    }

    @Override
    public UserCustomEvent deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            String json = new String(data, StandardCharsets.UTF_8);
            // Fully safe now because UserCustomEvent.class is explicitly defined
            return objectMapper.readValue(json, UserCustomEvent.class);
        } catch (Exception e) {
            throw new SerializationException("Error deserializing UserCustomEvent from topic: " + topic, e);
        }
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
