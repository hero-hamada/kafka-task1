package com.example.kafkatask1.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaSosConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaSosConsumer.class.getName());

    private String payload;

    @KafkaListener(topics = "${kafka.sos.signal.topic}", groupId = "${kafka.group.id}", concurrency = "3")
    public void listener(@Payload String sosSignal) {
        payload = sosSignal;
        LOG.info("Consumer received SOS signal {}", sosSignal);
    }

    public String getPayload() {
        return payload;
    }
}
