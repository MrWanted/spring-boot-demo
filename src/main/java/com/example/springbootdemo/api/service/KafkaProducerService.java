package com.example.springbootdemo.api.service;

import com.example.springbootdemo.api.util.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducerService {
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
       log.info(String.format("Message sent -> %s", message));
        kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
    }
}
