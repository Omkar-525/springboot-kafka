package com.omkar.springboot_kafka.kafka;

import com.omkar.springboot_kafka.entity.Employ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class EmployDataProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployDataProducer.class);

    @Autowired
    private KafkaTemplate<String, Employ> kafkaTemplate;

    public void sendMessage(Employ data){
        LOGGER.info(String.format("Data sent to topic -> %s",data.toString()));

        Message<Employ> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"EmployDataTopic")
                .build();

        kafkaTemplate.send(message);
    }
}
