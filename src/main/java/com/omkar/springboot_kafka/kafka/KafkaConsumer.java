package com.omkar.springboot_kafka.kafka;

import com.omkar.springboot_kafka.entity.Employ;
import com.omkar.springboot_kafka.infra.User;
import com.omkar.springboot_kafka.repository.EmployRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private EmployRepository employRepository;

    //JSON Consumer
    @KafkaListener(topics = "JSONTopic",
            groupId = "myGroup")
    public void consume(User message){
        LOGGER.info(String.format("Message Received -> %s", message));
    }

    //Normal consumer
    @KafkaListener(topics = "FirstTopic",
            groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message Received -> %s", message));
    }

    @KafkaListener(topics = "EmployDataTopic",
            groupId = "myGroup")
    public void consume(Employ data){
        LOGGER.info(String.format("Message Received -> %s", data));

        Employ employ = new Employ();
        data.setId(0L);
        employ.setFirstName(data.getFirstName());
        employ.setLastName(data.getLastName());
        employRepository.save(employ);
        LOGGER.info("Data saved into the database");

    }
}
