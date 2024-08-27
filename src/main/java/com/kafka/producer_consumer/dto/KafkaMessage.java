package com.kafka.producer_consumer.dto;

import lombok.Data;

/**
 * Created by alexandru.ciocan
 */
@Data
public class KafkaMessage {

    private String topic;
    private String key;
    private String message;

}
