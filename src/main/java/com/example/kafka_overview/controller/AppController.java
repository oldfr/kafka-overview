package com.example.kafka_overview.controller;

import com.example.kafka_overview.model.UserCustomEvent;
import com.example.kafka_overview.service.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/push")
public class AppController {

    private final KafkaProducer kafkaProducer;

    public AppController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping
    public String PushMessage() {
        try {
            UserCustomEvent userCustomEvent = new UserCustomEvent("userId4", "Event");
            kafkaProducer.send(userCustomEvent);
            return "SUCCESS";
        }
        catch (Exception ex) {
            System.out.println("ERROR while pushing data:"+ex);
            return "ERROR";
        }

    }
}
