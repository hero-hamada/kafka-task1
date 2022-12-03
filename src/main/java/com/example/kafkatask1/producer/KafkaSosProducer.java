package com.example.kafkatask1.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSosProducer {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaSosProducer.class.getName());

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaSosProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String sosSignal) {
        kafkaTemplate.send(topic, sosSignal);
        LOG.info("Producer sent sosSignal '{}' to TOPIC '{}'", sosSignal, topic);
    }
}
