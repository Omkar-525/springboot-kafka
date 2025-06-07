package com.omkar.springboot_kafka.kafka;

import com.omkar.springboot_kafka.infra.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JSONKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, User>  kafkaTemplate;

    public void sendMessage(User data){

        LOGGER.info(String.format("Message sent to topic -> %s", data.toString()));

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "JSONTopic")
                .build();

        kafkaTemplate.send(message);
    }

}
