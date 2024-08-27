package com.kafka.producer_consumer.controller;

import com.kafka.producer_consumer.dto.KafkaMessage;
import com.kafka.producer_consumer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alexandru.ciocan
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping(value = "/kafka/produceMessage")
    public void produce(@RequestBody KafkaMessage kafkaMessage) {
        kafkaProducerService.sendMessage(kafkaMessage.getTopic(), kafkaMessage.getKey(), kafkaMessage.getMessage());
    }
}
