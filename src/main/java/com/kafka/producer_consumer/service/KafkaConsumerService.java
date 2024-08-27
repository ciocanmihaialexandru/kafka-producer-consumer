package com.kafka.producer_consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alexandru.ciocan
 */
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "kafka-transactional-example", groupId = "group1")
    @Transactional("kafkaTransactionManager")
    public void consume(ConsumerRecord<String, String> record) {
        System.out.println("Consumed message: " + record.value());
        // Process your message here

        // Simulate a further Kafka operation in the same transaction
        // kafkaTemplate.send("other-topic", record.value());

        // The transaction manager will handle commit or rollback based on exceptions
    }
}
