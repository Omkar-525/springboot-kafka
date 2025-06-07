package com.omkar.springboot_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic normalTopic() {
        return TopicBuilder.name("NormalTopic").
                build();
    }

    @Bean
    public NewTopic jsonTopic(){
        return TopicBuilder.name("JSONTopic").
                build();
    }
}
