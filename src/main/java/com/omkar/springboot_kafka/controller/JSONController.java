package com.omkar.springboot_kafka.controller;
import com.omkar.springboot_kafka.infra.User;
import com.omkar.springboot_kafka.kafka.JSONKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONController {

    @Autowired
    private JSONKafkaProducer jsonKafkaProducer;

    // http://localhost:8080/json/publish
    @PostMapping("/json/publish")
    public ResponseEntity<String> publishMessage(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JSON Message sent to kafka topic");
    }
}
