package com.example.kafka_overview.model;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

public class CustomDeserialiser<UserEvent> implements Deserializer<UserEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();
//    private Class<UserEvent> targetType = UserEvent.class.getName();

    // Default constructor required by Kafka via reflection
    public CustomDeserialiser() {}

    // Programmatic constructor if initializing manually in Java code
/*    public CustomDeserialiser(Class<UserEvent> targetType) {
        this.targetType = targetType;
    }*/

/*    @SuppressWarnings("unchecked")
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Fallback: target type can be passed via Kafka config properties if needed
        String configKey = isKey ? "key.deserializer.type" : "value.deserializer.type";
        if (configs.containsKey(configKey)) {
            this.targetType = (Class<UserEvent>) configs.get(configKey);
        }
    }*/

    @Override
    public UserEvent deserialize(String topic, byte[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

/*        if (targetType == null) {
            throw new SerializationException("Target type for deserialization was not specified.");
        }*/

        try {
            // Convert byte array back into the specific POJO
            return (UserEvent) objectMapper.readValue(data, com.example.kafka_overview.model.UserEvent.class);
        } catch (Exception e) {
            throw new SerializationException("Error deserializing byte[] to Object via Jackson", e);
        }
    }

    @Override
    public void close() {
        // Cleanup resources here if required
    }
}
