package com.example.kafkatask1;

import com.example.kafkatask1.producer.KafkaSosProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaTask1Application {

    private static KafkaSosProducer kafkaProducer;

    public KafkaTask1Application(KafkaSosProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaTask1Application.class, args);
        kafkaProducer.send("sos-signal", "Help me!");
    }
}
