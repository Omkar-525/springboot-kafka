package com.omkar.springboot_kafka.controller;

import com.omkar.springboot_kafka.entity.Employ;
import com.omkar.springboot_kafka.kafka.EmployDataProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployController {

    @Autowired
    private EmployDataProducer employDataProducer;

    // http://localhost:8080/emp/publish
    @PostMapping("/emp/publish")
    public ResponseEntity<String> publishMessage(@RequestBody Employ employ){
        employDataProducer.sendMessage(employ);
        return ResponseEntity.ok("Data Sent to topic");
    }
}
