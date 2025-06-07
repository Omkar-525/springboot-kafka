package com.omkar.springboot_kafka.kafka;

import com.omkar.springboot_kafka.infra.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    //JSON Consumer
    @KafkaListener(topics = "JSONTopic", groupId = "myGroup")
    public void consume(User message){
        LOGGER.info(String.format("Message Received -> %s", message));
    }

    //Normal consumer
    @KafkaListener(topics = "FirstTopic", groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message Received -> %s", message));
    }
}
