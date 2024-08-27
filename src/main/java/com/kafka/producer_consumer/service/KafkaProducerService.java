package com.kafka.producer_consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by alexandru.ciocan
 */
@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String key, String message) {
        kafkaTemplate.executeInTransaction(operations -> {
           operations.send(topic, key, message);
           return true;
        });
    }
}
